package main.edu.truman.hieule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * FastScanner offers improved input reading speed over the built-in Scanner library.
 * @author Hieu Le
 * @version 9/11/16
 */
public class FastScanner {

    private BufferedReader bufferedReader;
    private StringTokenizer tokenizer;

    // Input buffer size to configure BufferReader.
    private static final int BUFFER_SIZE = 32768;

    /**
     * Constructs a new FastScanner that produces values scanned from the specified input stream.
     * @param source an input stream to be scanned.
     */
    public FastScanner(InputStream source) {
        bufferedReader = new BufferedReader(new InputStreamReader(source), BUFFER_SIZE);
        tokenizer = null;
    }

    /**
     * Finds and returns the next complete token from this scanner.
     * @return the next token.
     * @throws IllegalStateException if the associated stream cannot be read.
     * @throws NoSuchElementException if no more tokens are available.
     */
    public String next() throws IllegalStateException, NoSuchElementException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        return tokenizer.nextToken();
    }

    /**
     * Advances this scanner past the current line and returns the input that was skipped.
     * @return the line that was skipped.
     * @throws IllegalStateException if the associated stream cannot be read.
     * @throws NoSuchElementException if no line was found.
     */
    public String nextLine() throws NoSuchElementException {
        if (tokenizer != null && tokenizer.hasMoreTokens()) {
            StringBuilder line = new StringBuilder();
            while (tokenizer.hasMoreTokens()) {
                line.append(tokenizer.nextToken());
                line.append(' ');
            }
            // Truncate trailing spaces
            return line.toString().trim();
        }

        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Scans the next token of the input as an int.
     * @return the int scanned from the input.
     * @throws IllegalStateException if the associated stream cannot be read.
     * @throws InputMismatchException if the next token does not represent the Integer regular
     * expression, or is out of range.
     * @throws NoSuchElementException if input is exhausted.
     */
    public int nextInt() throws IllegalStateException, InputMismatchException,
            NoSuchElementException {
        String token = next();
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new InputMismatchException("Cannot parse int value from token: " + token);
        }
    }

    /**
     * Scans the next token of the input as a long.
     * @return the long scanned from the input.
     * @throws IllegalStateException if the associated stream cannot be read.
     * @throws InputMismatchException if the next token does not represent the Integer regular
     * expression, or is out of range.
     * @throws NoSuchElementException if input is exhausted.
     */
    public long nextLong() throws IllegalStateException, InputMismatchException,
            NoSuchElementException {
        String token = next();
        try {
            return Long.parseLong(token);
        } catch (NumberFormatException e) {
            throw new InputMismatchException("Cannot parse long value from token: " + token);
        }
    }

    /**
     * Scans the next token of the input as a double.
     * @return the double scanned from the input.
     * @throws IllegalStateException if the associated stream cannot be read.
     * @throws InputMismatchException if the next token does not match the Float regular
     * expression, or is out of range.
     * @throws NoSuchElementException if the input is exhausted.
     */
    public double nextDouble() throws IllegalStateException, InputMismatchException,
            NoSuchElementException {
        String token = next();
        try {
            return Double.parseDouble(token);
        } catch (NumberFormatException e) {
            throw new InputMismatchException("Cannot parse double value from token: " + token);
        }
    }
}
