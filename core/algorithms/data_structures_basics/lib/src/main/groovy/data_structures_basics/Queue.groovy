package data_structures_basics

import groovy.transform.CompileStatic

/**
 * FIFO queue built from scratch over Node.
 *
 * Contract stub (step 4b): every body stays at its failure indicator - -1 for
 * numbers and false for flags -, and no `null` is used outside the Node links.
 *
 * The default constructor yields the initialized, empty queue: `new Queue()` is
 * the contract's `init`.
 */
@CompileStatic
class Queue {
    private Node front
    private Node rear
    private int count

    /** Adds value at the rear of the queue (enqueue). */
    void enqueue(Integer value) {
        Node newNode = new Node(value)
        if (rear != null) {
            rear.next = newNode
        }
        rear = newNode
        if (front == null) {
            front = newNode
        }
        count++
    }

    /** Removes and returns the front value, or -1 when the queue is empty (dequeue). */
    int dequeue() {
        if (front == null) {
            return -1
        }
        int value = front.value
        front = front.next
        if (front == null) {
            rear = null
        }
        count--
        return value
    }

    /** Returns the front value without removing it, or -1 when empty (peek). */
    int peek() {
        return front?.value ?: -1
    }

    /** True when no nodes are stored (is_empty). */
    boolean isEmpty() {
        return count == 0
    }

    /** Number of nodes stored (size). */
    int getSize() {
        return count
    }
}
