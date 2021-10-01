package com.skillsoft.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;  //  @Timeout(4) to the @Test

public class EmployeeTest {
    static Employee devOps;
    static Employee tester;
    @BeforeAll
    public static void init(){
        tester = new Employee("Ann", "Automation Test Engineer");
        devOps = new Employee("Kelly", "Dev Ops Engineer");

        System.out.println("System Properties"); // specific to java platform
        System.out.println("os.arch: " +System.getProperty("os.version"));
        System.out.println("os.name: " +System.getProperty("os.name"));
        System.out.println("user.name: " +System.getProperty("user.name"));
        System.out.println("ALL: " + System.getenv());
    }

    @Test
    @Timeout(4)
    public void superLongTest() throws InterruptedException {
        System.out.println("super long test");
        Thread.sleep(10000);

    }

    @Test
    @DisplayName("Test Role Check")
    public void employeeRoleCheck ()throws InterruptedException{
        Thread.sleep(1000);
        System.out.println("Test Role check method");
//        assertEquals("Automation Test Engineer", tester.getRole());
    }

    @Test
    @DisplayName("Dev Ops Check")
    public void employeeDevRoleCheck () throws InterruptedException {
        System.out.println("Dev ops check");
        Thread.sleep(1000);
//        assertEquals("Dev Ops Engineer", devOps.getRole());
    }
}
