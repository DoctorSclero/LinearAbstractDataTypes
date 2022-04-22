package it.iisvittorioveneto.itt.nongenerics.stack;

import it.iisvittorioveneto.itt.nongenerics.observable.stack.ObservableStackLC;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackLCTest {

    private ObservableStackLC stack;

    @BeforeEach
    void setUp() {
        this.stack = new ObservableStackLC();
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