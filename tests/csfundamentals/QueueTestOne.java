package csfundamentals;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by jay on 7/28/17.
 */
public class QueueTestOne {

    private Queue queue = new Queue();

    @Test
    public void testQueueIsEmpty() {
        assertTrue(queue.isEmpty());
        assertEquals(queue.size(), 0);
    }

    @Test
    public void testIsNotEmpty() {
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        assertTrue(!queue.isEmpty());
    }

    @Test
    public void testIsOneEnQueue() {
        queue.enQueue(6);
        assertEquals(6, queue.peek());
        assertEquals(1, queue.size());
    }

    @Test
    public void testIsOneDeque() {
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.deQueue();
        assertEquals(2, queue.size());
    }

    @Test
    public void testEnQueueThenDeQueue () {
        queue.enQueue(3);
        queue.enQueue(4);
        assertTrue(!queue.isEmpty());
        queue.deQueue();
        assertTrue(!queue.isEmpty());
        queue.deQueue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testPeekOnEmpty() {
        assertEquals(0, queue.peek());
    }

    @Test
    public void testEnQueueThenPeek() {
        queue.enQueue(2);
        assertEquals(2, queue.peek());
    }

    @Test(expected = NullPointerException.class)
    public void testNullEnQueue() {
        queue.enQueue(null);
        assertEquals(2, queue.peek());
        assertTrue(queue.isEmpty());
    }
    @Test
    public void testOrdering() {
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);
        assertEquals(4,queue.peek());
        queue.deQueue();
        assertEquals(5,queue.peek());
        queue.deQueue();
        assertEquals(6,queue.peek());
    }

    @Test (expected = NullPointerException.class)
    public void testRemovingTillEmpty() throws NullPointerException {
        int numOfRemovals = 20;
        for (int i=0;i<numOfRemovals;i++) {
            queue.enQueue(i);
        }
        for (int i=0;i<numOfRemovals+1;i++) {
            queue.deQueue();
        }

        assertTrue(queue.isEmpty());
        assertEquals(queue.size(), 0);
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveOnEmptyQueue() throws NullPointerException{
        assertTrue(queue.isEmpty());
        queue.deQueue();
    }

    @Test (expected = NullPointerException.class)
    public void testPeekIntoEmptyQueue() throws NullPointerException{
        assertTrue(queue.isEmpty());
        queue.deQueue();
    }
}