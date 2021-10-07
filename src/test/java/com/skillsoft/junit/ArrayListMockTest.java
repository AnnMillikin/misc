package com.skillsoft.junit;

import org.junit.jupiter.api.*;
//import junit.framework.TestCase;
//import junit.framework.TestSuite; // no need for package qualification

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock; // static says to import all of the static members
import static org.mockito.Mockito.when;
/**
 * Mock instance of the java.util.ArrayList
 */
public class ArrayListMockTest {


    @Test
    public void mock3ArrayList() {
        ArrayList someArrayList = mock(ArrayList.class);

        when(someArrayList.contains("Alice")).thenReturn(true);
        when(someArrayList.contains("Bob")).thenReturn(false);

        assertTrue(someArrayList.contains("Alice"));
        assertFalse(someArrayList.contains("Bob"));

        when(someArrayList.get(0)).thenReturn("Alice");
        when(someArrayList.get(1)).thenReturn("Bob");
        when(someArrayList.get(2)).thenReturn("Dennis");

        assertEquals("Alice", someArrayList.get(0));
        assertEquals("Bob", someArrayList.get(1));
        assertEquals("Dennis", someArrayList.get(2));

        when(someArrayList.subList(100,103)).thenReturn(Arrays.asList("Alice", "Bob", "Dennis"));
        // below compares 2 iterable objects
        assertLinesMatch(Arrays.asList("Alice", "Bob", "Dennis"),someArrayList.subList(100,103));

        when(someArrayList.indexOf("Alice")).thenReturn(100);
        when(someArrayList.indexOf("Bob")).thenReturn(101);
        when(someArrayList.indexOf("Dennis")).thenReturn(102);

        assertEquals(100, someArrayList.indexOf("Alice"));
        assertEquals(101, someArrayList.indexOf("Bob"));
        assertEquals(102, someArrayList.indexOf("Dennis"));


    }

    /**
     * Remember the goal of mocks is to create a light version of an Object that the under test depends on
     */
    @Test
    public void mock2ArrayList() {
        ArrayList someArrayList = mock(ArrayList.class);
/**
 * strict stubbing refers to only stubbing those methods that are REQUIRED by the object under test
 */
        when(someArrayList.isEmpty()).thenReturn(true); // 3 stubs
        when(someArrayList.size()).thenReturn(23);
        when(someArrayList.toArray()).thenReturn(new Object[]{1, 3, 6, 9});

        assertTrue(someArrayList.isEmpty());
        assertEquals(23,someArrayList.size());
        assertArrayEquals(new Object[]{1, 3, 6, 9},someArrayList.toArray());
    }

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
