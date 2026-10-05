package data_structures_basics

import groovy.transform.CompileStatic

/**
 * Shared linked cell used by LinkedList, Stack and Queue.
 *
 * Contract stub (step 4b): the value is immutable after construction and the
 * link is mutable. `next` is the only nullable value of the module; the cell is
 * created with `new Node(value)` (the contract's `init`) and its value and link
 * are read or written through the Groovy properties (`get_value`, `get_next`,
 * `set_next`).
 */
@CompileStatic
class Node {
    final Integer value
    Node next

    Node(Integer value) {
        this.value = value
    }
}
