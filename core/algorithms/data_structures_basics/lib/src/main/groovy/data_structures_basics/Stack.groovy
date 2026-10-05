package data_structures_basics

import groovy.transform.CompileStatic

/**
 * LIFO stack built from scratch over Node.
 *
 * Contract stub (step 4b): every body stays at its failure indicator - -1 for
 * numbers and false for flags -, and no `null` is used outside the Node links.
 *
 * The default constructor yields the initialized, empty stack: `new Stack()` is
 * the contract's `init`.
 */
@CompileStatic
class Stack {
    private Node top
    private int count

    /** Pushes value on top of the stack (push). */
    void push(Integer value) {
    }

    /** Removes and returns the top value, or -1 when the stack is empty (pop). */
    int pop() {
        -1
    }

    /** Returns the top value without removing it, or -1 when empty (peek). */
    int peek() {
        -1
    }

    /** True when no nodes are stored (is_empty). */
    boolean isEmpty() {
        false
    }

    /** Number of nodes stored (size). */
    int getSize() {
        0
    }
}
