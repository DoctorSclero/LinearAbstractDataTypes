package it.iisvittorioveneto.itt.nongenerics.stack;

import org.junit.jupiter.api.BeforeEach;

class StackVTest {

    private StackV stack;

    @BeforeEach
    void setUp() {
        this.stack = new StackV(6);
    }

    @org.junit.jupiter.api.Test
    void testPopTopPush() {
        String input    = "pietro";
        String expected = "orteip";

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        for (int i = 0; i < input.length(); i++) {
            assertEquals(expected.charAt(i), stack.pop());
        }
    }

    @org.junit.jupiter.api.Test
    void flush() {
        String input    = "pietro";
        int    expected = 0;

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        stack.flush();
        assertEquals(expected, stack.size());
    }

    @org.junit.jupiter.api.Test
    void size() {
        String input    = "pietro";
        int    expected = 6;

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        assertEquals(expected, stack.size());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(stack.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isFull() {
        String input = "pietro";
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        assertTrue(stack.isFull());
    }
}