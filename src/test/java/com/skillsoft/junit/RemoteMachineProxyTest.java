package com.skillsoft.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class RemoteMachineProxyTest {

    private Iterator<String> iteratorMock;

    @BeforeEach
    public void setupMocks() {
        iteratorMock = mock(Iterator.class);

        when(iteratorMock.next())
                .thenReturn("John, john@infomoto.com, 23")
                .thenReturn("James, james@infomoto.com, 45")
                .thenReturn("Justine, justine@infomoto.com, 28")
                .thenReturn("Johanna, johanna@infomoto.com, 34");
    }

    @AfterEach
    public void teardownMocks() {
        iteratorMock = null;
    }

    @Test
    public void testReoteMachineProxyGetNextFile(){
        RemoteMachineProxy proxy = new RemoteMachineProxy("test_url");
        proxy.setRemoteFileIterator(iteratorMock) ;

        when(iteratorMock.hasNext()).thenReturn(true);
        assertEquals("john@infomoto.com", proxy.getNextFile());

        when(iteratorMock.hasNext()).thenReturn(true);
        assertEquals("james@infomoto.com", proxy.getNextFile());
        when(iteratorMock.hasNext()).thenReturn(true);
        assertEquals("justine@infomoto.com", proxy.getNextFile());
        when(iteratorMock.hasNext()).thenReturn(true);
        assertEquals("johanna@infomoto.com", proxy.getNextFile());

        /**
         * the last return value will continue to be returned for
         * the remaining invocations to getNextFile
         */
        when(iteratorMock.hasNext()).thenReturn(true);
        assertEquals("johanna@infomoto.com", proxy.getNextFile());

    }
}


