package data_structures_basics

import groovy.transform.CompileStatic

/**
 * Singly linked list built from scratch over Node.
 *
 * Contract stub (step 4b): the algorithm is written in step 5, so every body
 * stays at its failure indicator - -1 for numbers, false for flags and 0 for
 * counters -, and no `null` is used outside the Node links.
 *
 * The default constructor yields the initialized, empty list: `new LinkedList()`
 * is the contract's `init`.
 */
@CompileStatic
class LinkedList {
    private Node head
    private Node tail
    private int count

    /** Head value, or -1 when the list is empty (get_head). */
    int getHeadValue() {
        return head?.value ?: -1
    }

    /** Inserts value at the head (insert_head). */
    void insertHead(Integer value) {
        Node newNode = new Node(value)
        newNode.next = head
        head = newNode
        if (tail == null) {
            tail = newNode
        }
        count++
    }

    /** Inserts value at the tail (insert_tail). */
    void insertTail(Integer value) {
        Node newNode = new Node(value)
        if (tail != null) {
            tail.next = newNode
        }
        tail = newNode
        if (head == null) {
            head = newNode
        }
        count++
    }

    /** Removes the first occurrence of value; false when it is absent (delete). */
    boolean delete(Integer value) {
        Node current = head
        Node previous = null
        while (current != null) {
            if (current.value == value) {
                if (previous != null) {
                    previous.next = current.next
                } else {
                    head = current.next
                }
                if (current.next == null) {
                    tail = previous
                }
                count--
                return true
            }
            previous = current
            current = current.next
        }
        return false
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
