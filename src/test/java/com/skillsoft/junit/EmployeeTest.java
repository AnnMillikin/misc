package com.skillsoft.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;  //  @Timeout(4) to the @Test
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.CsvSource;  // specified with annotation
import org.junit.jupiter.params.provider.CsvFileSource;  // specified in csv file (stating the obvious here)
import org.junit.jupiter.params.provider.MethodSource; // method provides params
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ValueSource;

import javax.naming.InvalidNameException;
import java.util.stream.Stream; // needed with the above

/**
 * Mockito
 * - mocks create an entirely new dummy object
 * - spies define behavior for specific methods
 * - argument captors verify input arguments
 * - argument matchers to specify input arguments
 *
 */
public class EmployeeTest {
    static Employee employee;
    static double salary;

    @BeforeAll
    public static void init(){
        salary = 200;
        employee = new Employee("Ann", "Automation Test Engineer", salary, "Tester");
    //    employee = new Employee("Kelly", "Dev Ops Engineer", salary, "Developer");

        System.out.println("System Properties"); // specific to java platform
        System.out.println("os.arch: " +System.getProperty("os.version"));
        System.out.println("os.name: " +System.getProperty("os.name"));
        System.out.println("user.name: " +System.getProperty("user.name"));
        System.out.println("ALL: " + System.getenv());
        System.out.println("BeforeAll salary: "+ salary);
    }

    static Stream<String> getLastNames() {
        return Stream.of("Al4d", "B3nson", "$mith", "@lford");
    }

    /**
     *
     * @param name
     */
    @ParameterizedTest
    @MethodSource("getLastNames") // method defined above to use for this test
    @DisplayName("method name test")
    void methodNameTest(String name){
        Employee employee = new Employee(name, "DevOps Engineer", salary, "Tester");
        assertThrows(InvalidNameException.class,
                () -> {employee.validateLastName();},
            "Throws Invalid Name Test");
    }

    @ParameterizedTest
    @ValueSource(strings = {"developer", "release manager", "talent manager"})
    @DisplayName("role converter name test")
    void valueSourceRoleCoverterNameTest(@ConvertWith(RoleConverter.class) String role){
        Employee employee = new Employee("Ann", role, salary, "Employee");
        System.out.println("Value of role: " + role);
        assertEquals(role, employee.getRole());
    }

    @ParameterizedTest(name="Test #{index} - Last name: {0}")
    @MethodSource("getLastNames") // method defined above to use for this test
    @DisplayName("argument name test")
    void argumentNameTest(String name){
        Employee employee = new Employee(name, "DevOps Engineer", salary, "Tester");
        assertThrows(InvalidNameException.class,
                () -> {employee.validateLastName();},
                "Throws Invalid Name Test");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/empnames.csv", numLinesToSkip = 1) // skip the header line
    @DisplayName("csv file name test")
    void csvFileNameTest(String name){
        Employee employee = new Employee(name, "DevOps Engineer", salary, "Tester");
        assertEquals(name, employee.getEmployeeName());
    }

    @ParameterizedTest
    @CsvSource({"Kelly", "Scott", "Sonja"}) // these can be comma separated "fname, lname" matching the order of the method parameters - using trim()
    @DisplayName("csv name test")
    void csvNameTest(String name){
        Employee employee = new Employee(name, "DevOps Engineer", salary, "Tester");
        assertEquals(name, employee.getEmployeeName());
    }


    @ParameterizedTest
    @EmptySource
    @DisplayName("empty name test")
    void emptyNameTest(String name){
        Employee employee = new Employee(name, "DevOps Engineer", salary, "Tester");
        assertEquals("", employee.getEmployeeName());
    }


    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("empty and null name test")
    void emptyAndNullNameTest(String name){
        Employee employee = new Employee(name, "DevOps Engineer", salary, "Tester");
        assertTrue(employee.getEmployeeName() == null || employee.getEmployeeName().isEmpty());
    }


    @ParameterizedTest
    @NullSource
    @DisplayName("Null Name Check")
    void nameTest(String name) {
        Employee employee = new Employee(name, "DevOps Engineer", salary, "Tester");

        assertNull(employee.getEmployeeName());
    }

    @RepeatedTest(5)
    @DisplayName("Salary Update")
    void salaryUpdateTest(){
        double salaryIncrement = 1.0;
        employee.adjustSalary(salaryIncrement);
        salary+=salaryIncrement;
        System.out.println("in salaryUpdateTest method, salary: "+ salary + " employee.getSalary() "+employee.getSalary());
        assertEquals(salary,employee.getSalary(),"Test Salary Updates");

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
