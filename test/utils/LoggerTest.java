package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

    private OutputStream out;

    @BeforeEach
    void setUp() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    void testLogPrint() {
        Logger.logPrintString("Hello");
        assertEquals("[Print] Hello\n", out.toString());
    }

    @Test
    void testMultipleLogPrint() {
        String[] test = {"Hello", "world", "Bob"};
        Logger.logPrintStrings(test);
        assertEquals("[Print] Hello\n[Print] world\n[Print] Bob\n", out.toString());
    }
}