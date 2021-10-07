package com.skillsoft.junit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import java.util.Comparator;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TreeSetTest {

    private Comparator<String> comparatorMock;

    @BeforeEach
    public void setupMocks() {
        Comparator<String> comparatorMock = mock(Comparator.class);

        when(comparatorMock.compare("Alice", "Bob")).thenReturn(1);
        when(comparatorMock.compare("Bob", "Dennis")).thenReturn(1);
        when(comparatorMock.compare("Alice", "Dennis")).thenReturn(1);

        when(comparatorMock.compare("Bob", "Alice")).thenReturn(-1);
        when(comparatorMock.compare("Dennis", "Bob")).thenReturn(-1);
        when(comparatorMock.compare("Dennis", "Alice")).thenReturn(-1);

        when(comparatorMock.compare("Alice", "Alice")).thenReturn(0);
        when(comparatorMock.compare("Bob", "Bob")).thenReturn(0);
        when(comparatorMock.compare("Dennis", "AlDennisice")).thenReturn(0);

        assertTrue(comparatorMock.compare("Alice", "Dennis") >0);
        assertTrue(comparatorMock.compare("Dennis", "Alice") <0);
        assertEquals(0,comparatorMock.compare("Bob", "Bob")) ;
    }

    @AfterEach
    public void releaseMocks() {
        comparatorMock = null;
    }

    @Test
    public void testTreeSet() {
        TreeSet<String> treeSet = new TreeSet<>(comparatorMock);

        treeSet.add("Bob");
        treeSet.add("Alice");
        treeSet.add("Dennis");

        for (String element : treeSet) {
            System.out.println(element);
        }

    }

    @Test
    public void tree2Test() {
        TreeSet<String> treeSet = new TreeSet<>(comparatorMock);

        treeSet.add("Bob");
        treeSet.add("Alice");
        treeSet.add("Dennis");

        for (String element : treeSet) {
            System.out.println(element);
        }
        assertEquals("Dennis", treeSet.last());
        assertEquals("Alice", treeSet.first());

        assertEquals("Bob", treeSet.higher("Alice"));
        assertEquals("Bob", treeSet.lower("Dennis"));
    }
}
