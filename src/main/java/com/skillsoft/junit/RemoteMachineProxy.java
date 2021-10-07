package com.skillsoft.junit;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * NOTE: Assume that this is a proxy that uses a URL to connect to another
 * machine and allows us to perform operations on the other machine
 */
public class RemoteMachineProxy {
    public void setRemoteFileIterator(Iterator<String> remoteFileIterator) {
        this.remoteFileIterator = remoteFileIterator;
    }

    private final String remoteUrl;
    private Iterator<String> remoteFileIterator; // mocking this

    public RemoteMachineProxy(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public String getNextFile() {
    if(remoteFileIterator.hasNext()){
        String record = remoteFileIterator.next();

        Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher((record));

        if(m.find()){
            return m.group();
        }

        return remoteFileIterator.next();
        }
        return null;
    }

    private void connect() {
/**
 * NOTE: Assume that this is a proxy that uses a URL to connect to another
 * machine and allows us to perform operations on the other machine
 */

    }
}
