package com.skillsoft.junit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.mockito.Mockito.mock;

public class ArrayListMock {
    public static void main( String[] args){
        System.out.println("Hello World!");
    }


    @Test
    public void mockArrayListTest() {
        ArrayList someArrayList  = mock(ArrayList.class);

        System.out.println("toString() of someArrayList: " + someArrayList);
        System.out.println("getClass() of mock: " + someArrayList.getClass());
        System.out.println("getClass().getSuperClass() of mock: " + someArrayList.getClass().getSuperclass());
    }

}
