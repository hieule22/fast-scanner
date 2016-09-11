package test.edu.truman.hieule;

import main.edu.truman.hieule.FastScanner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Test class for FastScanner.
 * @author Hieu Le
 * @version 9/11/16
 */
public class FastScannerTest {

    /**
     * Returns a FastScanner that scans values from specified String.
     * @param input the String where values are scanned from.
     * @return a FastScanner object.
     */
    private FastScanner getScannerFromString(String input) {
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        return new FastScanner(stream);
    }

    @org.junit.Test
    public void testNext() throws Exception {
        final String[] tokens = {"Foo", "Bar", "Quoz"};
        StringBuilder builder = new StringBuilder();
        for (String token : tokens) {
            builder.append(token);
            builder.append(' ');
        }

        FastScanner scanner = getScannerFromString(builder.toString());
        for (String token : tokens) {
            assertEquals(scanner.next(), token);
        }
    }

    @org.junit.Test
    public void testNextLine() throws Exception {
        final String[] lines = {"Foo", "Bar", "Quoz"};
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            builder.append(line);
            builder.append('\n');
        }

        FastScanner scanner = getScannerFromString(builder.toString());
        for (String line : lines) {
            assertEquals(scanner.nextLine(), line);
        }
    }

    @org.junit.Test
    public void testNextInt() throws Exception {
        final int[] values = {0, 12, 999, -999, Integer.MAX_VALUE, Integer.MIN_VALUE};
        StringBuilder builder = new StringBuilder();
        for (int value : values) {
            builder.append(Integer.toString(value));
            builder.append(' ');
        }

        FastScanner scanner = getScannerFromString(builder.toString());
        for (int value : values) {
            assertEquals(scanner.nextInt(), value);
        }
    }

    @org.junit.Test
    public void testNextLong() throws Exception {
        final long[] values = {0, 12, 999, -999, Long.MAX_VALUE, Long.MIN_VALUE};
        StringBuilder builder = new StringBuilder();
        for (long value : values) {
            builder.append(Long.toString(value));
            builder.append(' ');
        }

        FastScanner scanner = getScannerFromString(builder.toString());
        for (long value : values) {
            assertEquals(scanner.nextLong(), value);
        }
    }

    @org.junit.Test
    public void testNextDouble() throws Exception {
        final double[] values = {0.0, 12.5, 999.35, -999.15, Double.MAX_VALUE, Double.MIN_VALUE};
        StringBuilder builder = new StringBuilder();
        for (double value : values) {
            builder.append(Double.toString(value));
            builder.append(' ');
        }

        FastScanner scanner = getScannerFromString(builder.toString());
        final double epsilon = 1e-6;
        for (double value : values) {
            assertEquals(scanner.nextDouble(), value, epsilon);
        }
    }
}