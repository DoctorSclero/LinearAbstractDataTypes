package it.iisvittorioveneto.itt.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackLCTest {

    private StackLC stack;

    @BeforeEach
    void setUp() {
        this.stack = new StackLC();
    }

    @Test
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

    @Test
    void size() {
        String input    = "pietro";
        int    expected = 6;

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        assertEquals(expected, stack.size());
    }

    @Test
    void flush() {
        String input    = "pietro";
        int    expected = 0;

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        stack.flush();
        assertEquals(expected, stack.size());
    }

    @Test
    void isEmpty() {
        assertTrue(stack.isEmpty());
    }
}