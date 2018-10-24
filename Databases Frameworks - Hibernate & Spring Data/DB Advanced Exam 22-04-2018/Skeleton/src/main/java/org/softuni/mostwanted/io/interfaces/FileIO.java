package org.softuni.mostwanted.io.interfaces;

import java.io.IOException;

public interface FileIO {
    String read(String file) throws IOException;

    void write(String fileContent, String file) throws IOException;
}
