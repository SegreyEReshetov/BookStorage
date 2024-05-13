package org.sergei.reader;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для чтения из файлов.
 */
public class FileReader {
    private static final Logger LOG = Logger.getLogger(FileReader.class);

    /**
     * Метод для считывания из файла
     * @param fileName имя файла
     * @return
     */
    public static List<String> readFromFile(final String fileName) {
        List<String> lines = new ArrayList(); 
        try {
            lines = Files.readAllLines(Path.of(fileName));
        } catch (IOException exception) {
            LOG.error(exception.getMessage());
        }
        return lines;
    }
}
