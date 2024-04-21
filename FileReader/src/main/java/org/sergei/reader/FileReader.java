package org.sergei.reader;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private static final Logger log = Logger.getLogger(FileReader.class);

    public static List<String> readFromFile(String fileName) {
        List<String> lines = new ArrayList(); 
        try {
            lines = Files.readAllLines(Path.of(fileName));
        } catch (IOException exception) {
            log.error(exception.getMessage());
        }
        return lines;
    }
}
