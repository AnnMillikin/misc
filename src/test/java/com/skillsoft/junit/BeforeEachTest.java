package com.skillsoft.junit;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class BeforeEachTest {
    String someVar;

    @BeforeEach
    public void init(){
        System.out.println("BeforeEach method");
    }

    @Test
    public void myTest() {
        System.out.println("Test method");
    }

    @AfterEach
    public void breakDown(){
        System.out.println("AfterEach method");
    }
}
