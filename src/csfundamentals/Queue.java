package csfundamentals;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by jay on 7/28/17.
 */
public class Queue {

    /**
     * Time Complexity - O(1) for push operation , Amortized O(1) for pop operation.
     * Space Complexity - O(n) for extra memory to Store elements
     * */

    private Deque<Integer> enq;
    private Deque<Integer> deq;
    public int front;

    /** Initialize your data structure here. */
    public Queue() {
        enq = new LinkedList<>();
        deq = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void enQueue(Integer x) {
        if (enq.isEmpty())
            front = x;
        enq.push(x);
    }
    /** In worst case scenario when deq is empty and we need to pop all the elements enq and push it onto deq where
     * the complexity becomes 2 O(n) else it would ne O(1).
     * */

    /** Removes the element from in front of queue and returns that element. */
    public int deQueue() {
        if (deq.isEmpty()) {
            while (!enq.isEmpty())
                deq.push(enq.pop());
        }
        if (!deq.isEmpty()) {
            return deq.pop();
        }
        throw new NullPointerException();
    }

    /** The front element is kept in constant memory and is modified when we push an element */

    /** Get the front element. */
    public int peek() {
        if (!deq.isEmpty()) {
            return deq.peek();
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean isEmpty() {
        return enq.isEmpty() && deq.isEmpty();
    }

    public int size() {
        return enq.size() + deq.size();
    }
}
