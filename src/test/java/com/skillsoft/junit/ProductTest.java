package com.skillsoft.junit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.junit.jupiter.api.condition.EnabledIfSystemProperties;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
// by default @Test run in random order
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer; //@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
import org.junit.jupiter.api.Order; // @Order(1) for each @Test
import org.junit.jupiter.api.TestMethodOrder; // @Order(1) for each @Test
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.Timeout;  //  @Timeout(4) to the @Test

/**
 * in junit-platform.properties file for concurrent execution:
 * junit.jupiter.execution.parallel.enabled = true
 * junit.jupiter.execution.parallel.mode.default = concurrent
 * junit.jupiter.execution.parallel.mode.classes.default = concurrent
 */

///////////////     Testing various JUnit 5 annotations ////////////////////
//@TestMethodOrder(MethodOrderer.DisplayName.class) // runs alpha based on display name
//@TestMethodOrder(MethodOrderer.MethodName.class) // run order alpha based on method name
//@TestMethodOrder(MethodOrderer.Random.class) // varies with each run - no duh
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Execution(ExecutionMode.CONCURRENT) // must have junit.platform.properties setting junit.jupiter.execution.parallel.enabled = true;
public class ProductTest {
    static Product tv;

    @BeforeAll
    public static void init(){
        tv = new Product("Diallonic", "Delta", 13423, 800.0, "Electronics");

        System.out.println("System Properties"); // specific to java platform
        System.out.println("os.arch: " +System.getProperty("os.version"));
        System.out.println("os.name: " +System.getProperty("os.name"));
        System.out.println("user.name: " +System.getProperty("user.name"));
        System.out.println("PWD: " + System.getenv("PWD"));
        System.out.println("USER: " + System.getenv("USER"));
        System.out.println("ALL: " + System.getenv());
    }

    @Test
    @Timeout(4)
    public void superLongTest() throws InterruptedException {
        System.out.println("super long test");
        Thread.sleep(10000);

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Test
    @EnabledOnOs(OS.WINDOWS)
    @DisabledOnOs(OS.AIX)
    public @interface MyCustomTestConditions {
        // meta annotations - applies to all @Test that have
        // @MyCustomTestConditions annotation
    }

    @MyCustomTestConditions
    @Test
    @DisplayName("Brand Name Check")
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_17)
    @EnabledIfSystemProperty(named = "os.name", matches = "Windows 10")
    public void brandNameTest()throws InterruptedException{
        Thread.sleep(5000);

        assertEquals("Diallonic", tv.getBrandName());
    }

    @Test
    @DisplayName("Price Check")
    @EnabledOnJre(JRE.JAVA_17)
    @EnabledIfSystemProperty(named = "os.version", matches = "10\\..*")
    public void priceTest() throws InterruptedException{
        Thread.sleep(5000);
        assertEquals(800, tv.getPrice());
    }

    @Test
    @DisplayName("Category Check")
    @Order(1)
    public void categoryTest()throws InterruptedException{
        Thread.sleep(5000);
        assertEquals("Electronics", tv.getCategory());
    }
}
