package it.iisvittorioveneto.itt.nongenerics.queue;

import it.iisvittorioveneto.itt.nongenerics.observable.queue.QueueV;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueVTest {

    private QueueV queue;

    @BeforeEach
    void setUp() {
        this.queue = new QueueV(6);
    }

    @Test
    void flush() {
        String input    = "pietro";
        int    expected = 0;

        for (int i = 0; i < input.length(); i++) {
            queue.enQueue(input.charAt(i));
        }
        queue.flush();
        assertEquals(expected, queue.size());
    }

    @Test
    void enQueue() {
        String input    = "pietro";
        String expected = "pietro";

        for (int i = 0; i < input.length(); i++) {
            queue.enQueue(input.charAt(i));
        }

    }

    @Test
    void deQueue() {
        String input    = "pietro";
        String expected = "pietro";

        enQueue();
        for (int i = 0; i < input.length(); i++) {
            assertEquals(expected.charAt(i), queue.deQueue());
        }
    }

    @Test
    void size() {
        String input    = "pietro";
        int    expected = 6;

        for (int i = 0; i < input.length(); i++) {
            queue.enQueue(input.charAt(i));
        }
        assertEquals(expected, queue.size());
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void isFull() {
        String input = "pietro";
        for (int i = 0; i < input.length(); i++) {
            queue.enQueue(input.charAt(i));
        }
        assertTrue(queue.isFull());
    }
}