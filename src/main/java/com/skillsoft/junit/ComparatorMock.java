package com.skillsoft.junit;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ComparatorMock {

    @Test
    public void mockComparator() {
        Comparator<String> comparatorMock = mock(Comparator.class);

        System.out.println("toString() of Comparator: " + comparatorMock);
        System.out.println("getClass() of mock: " + comparatorMock.getClass());
        System.out.println("getClass().getSuperClass() of mock: " + comparatorMock.getClass().getSuperclass());
    }

    @Test
    public void mock2Comparator() {
        Comparator<String> comparatorMock = mock(Comparator.class);

        when(comparatorMock.compare("Alice", "Bob")).thenReturn(1);
        when(comparatorMock.compare("Bob", "Dennis")).thenReturn(1);
        when(comparatorMock.compare("Alice", "Dennis")).thenReturn(1);

        when(comparatorMock.compare("Bob", "Alice")).thenReturn(-1);
        when(comparatorMock.compare("Dennis", "Bob")).thenReturn(-1);
        when(comparatorMock.compare("Dennis", "Alice")).thenReturn(-1);

        assertTrue(comparatorMock.compare("Alice", "Dennis") >0);
        assertTrue(comparatorMock.compare("Dennis", "Alice") <0);
        assertEquals(0,comparatorMock.compare("Bob", "Bob")) ;

    }
}
