package com.skillsoft.junit;

import org.junit.jupiter.api.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite; // no need for package qualification

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.mock; // static says to import all of the static members

/**
 * Mock instance of the java.util.ArrayList
 */
public class ArrayListMockTest {

    @Test
    public void mockArrayList() {
        ArrayList someArrayList = mock(ArrayList.class);

        System.out.println("toString() of mock: " + someArrayList);
        System.out.println("getClass() of mock: " + someArrayList.getClass());
        System.out.println("getClass().getSuperClass() of mock: " + someArrayList.getClass().getSuperclass());

        System.out.println("someArrList instance of ArrayList: " +(someArrayList instanceof ArrayList));
        System.out.println("someArrList instance of List: " +(someArrayList instanceof List));
        System.out.println("someArrList instance of Collection: " +(someArrayList instanceof Collection));
        System.out.println("someArrList instance of Iterable: " +(someArrayList instanceof Iterable));
        System.out.println("someArrList instance of Object: " +(someArrayList instanceof Object));
    }
}
