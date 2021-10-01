package com.skillsoft.junit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class AccountDetailsTest {
    static AccountDetails accountDetails;

    @BeforeAll
    static void initAll (){
        accountDetails = new AccountDetails("Anita ", 123456.1, 1, 5000.00, "Savings");
        System.out.println("@BeforeAll");
    }

    @AfterAll
    static  void teardownAll (){
        System.out.println("Final balance: " + accountDetails.getBalance());
        accountDetails = null;
        System.out.println("@AfterAll");
    }

    @BeforeEach
    public void init(){
        System.out.println("@BeforeEach block has been executed");
        System.out.println("Account balance: " +accountDetails.getBalance());
    }

    @Test
     public void depositTest(){
        accountDetails.deposit(500);
        System.out.println("@Test block for deposit has been executed");
    }

    @Test
     public void withdrawTest(){
        accountDetails.withdraw(1000);
        System.out.println("@Test block for withdraw has been executed");
    }

//    @Test
//    public void validateName(){
//        assertTrue(accountDetails.getName().matches("^[a-zA-Z ]+$"));
//    }
//
//    @Test
//    public void validateBalance(){
//        assertTrue(accountDetails.getBalance()>=0);
//    }

    @AfterEach
    public void balance(){
        System.out.println("@AfterEach has been executed");
        System.out.println("Account balance: " + accountDetails.getBalance());
    }

}
