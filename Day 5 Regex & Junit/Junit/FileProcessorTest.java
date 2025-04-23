package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

class FileProcessorTest {
    FileProcessor processor = new FileProcessor();

    @Test void testWriteAndReadFile() throws IOException {
        String file = "test.txt";
        processor.writeToFile(file, "Hello");
        String content = processor.readFromFile(file);
        assertEquals("Hello", content);
        new File(file).delete();
    }

    @Test void testFileExists() throws IOException {
        String file = "exists.txt";
        processor.writeToFile(file, "Check");
        assertTrue(new File(file).exists());
        new File(file).delete();
    }

    @Test void testFileNotFound() {
        assertThrows(IOException.class, () -> processor.readFromFile("no_file.txt"));
    }
}
