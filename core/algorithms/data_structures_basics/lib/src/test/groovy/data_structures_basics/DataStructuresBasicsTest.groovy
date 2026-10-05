package data_structures_basics

import spock.lang.Specification

class DataStructuresBasicsTest extends Specification {

    static final Integer FIRST_VALUE = 10
    static final Integer SECOND_VALUE = 20
    static final Integer HEAD_VALUE = 5
    static final Integer THIRD_VALUE = 30
    static final Integer REUSED_VALUE = 40
    static final Integer ABSENT_VALUE = 99
    static final int EMPTY_SIZE = 0
    static final int FAILED_VALUE = -1

    private static void assertNodeCases() {
        Node firstNode = new Node(FIRST_VALUE)
        assert firstNode.value == FIRST_VALUE :
                'Node should expose its value in the initialize and observe value/link case'
        assert firstNode.next == null :
                'Node should expose native absence for its link in the initialize and observe value/link case'

        Node secondNode = new Node(SECOND_VALUE)
        firstNode.next = secondNode
        assert firstNode.next.value == SECOND_VALUE :
                'Node should traverse to the linked value in the initialize another node, link and traverse case'
        assert secondNode.next == null :
                'Node should preserve native absence for the second link in the initialize another node, link and traverse case'
    }

    private static void assertLinkedListCases(LinkedList list) {
        assert list.isEmpty() :
                'LinkedList should report empty in the empty state case'
        assert list.size == EMPTY_SIZE :
                'LinkedList should have size zero in the empty state case'
        assert list.headValue == FAILED_VALUE :
                'LinkedList should return the failure indicator in the empty state case'

        list.insertTail(FIRST_VALUE)
        list.insertTail(SECOND_VALUE)
        list.insertHead(HEAD_VALUE)
        list.insertTail(FIRST_VALUE)
        assert list.size == 4 :
                'LinkedList should have four elements in the insert at both ends case'
        assert list.headValue == HEAD_VALUE :
                'LinkedList should expose the first traversed value in the insert at both ends case'

        assert list.delete(FIRST_VALUE) :
                'LinkedList should delete the first occurrence in the delete first occurrence case'
        assert list.headValue == HEAD_VALUE :
                'LinkedList should retain its head after the delete first occurrence case'
        assert list.size == 3 :
                'LinkedList should have size three in the delete first occurrence case'

        assert !list.delete(ABSENT_VALUE) :
                'LinkedList should return its failure indicator in the absent value case'
        assert list.headValue == HEAD_VALUE :
                'LinkedList should preserve its traversal in the absent value case'
        assert list.size == 3 :
                'LinkedList should preserve its size in the absent value case'

        assert list.delete(HEAD_VALUE) :
                'LinkedList should delete the head in the empty the list case'
        assert list.delete(SECOND_VALUE) :
                'LinkedList should delete the middle value in the empty the list case'
        assert list.delete(FIRST_VALUE) :
                'LinkedList should delete the remaining value in the empty the list case'
        assert list.isEmpty() :
                'LinkedList should report empty in the empty the list case'
        assert list.size == EMPTY_SIZE :
                'LinkedList should have size zero in the empty the list case'
        assert list.headValue == FAILED_VALUE :
                'LinkedList should return the failure indicator in the empty the list case'
    }

    private static void assertStackCases(Stack stack) {
        assert stack.isEmpty() :
                'Stack should report empty in the empty state and failed removal case'
        assert stack.size == EMPTY_SIZE :
                'Stack should have size zero in the empty state and failed removal case'
        assert stack.peek() == FAILED_VALUE :
                'Stack should return the failure indicator from peek in the empty state and failed removal case'
        assert stack.pop() == FAILED_VALUE :
                'Stack should return the failure indicator from pop in the empty state and failed removal case'

        stack.push(FIRST_VALUE)
        stack.push(SECOND_VALUE)
        stack.push(THIRD_VALUE)
        assert stack.peek() == THIRD_VALUE :
                'Stack should expose the latest value in the LIFO and non-mutating peek case'
        assert stack.size == 3 :
                'Stack should preserve size after peek in the LIFO and non-mutating peek case'

        assert stack.pop() == THIRD_VALUE :
                'Stack should remove the top value in the removal and reuse case'
        stack.push(REUSED_VALUE)
        assert stack.pop() == REUSED_VALUE :
                'Stack should remove the reused top value in the removal and reuse case'
        assert stack.pop() == SECOND_VALUE :
                'Stack should preserve LIFO order in the removal and reuse case'
        assert stack.pop() == FIRST_VALUE :
                'Stack should remove the oldest remaining value in the removal and reuse case'
        assert stack.isEmpty() :
                'Stack should report empty after the removal and reuse case'
        assert stack.size == EMPTY_SIZE :
                'Stack should have size zero after the removal and reuse case'

        assert stack.pop() == FAILED_VALUE :
                'Stack should return the failure indicator in the empty after removal case'
        assert stack.isEmpty() :
                'Stack should remain empty in the empty after removal case'
    }

    private static void assertQueueCases(Queue queue) {
        assert queue.isEmpty() :
                'Queue should report empty in the empty state and failed removal case'
        assert queue.size == EMPTY_SIZE :
                'Queue should have size zero in the empty state and failed removal case'
        assert queue.peek() == FAILED_VALUE :
                'Queue should return the failure indicator from peek in the empty state and failed removal case'
        assert queue.dequeue() == FAILED_VALUE :
                'Queue should return the failure indicator from dequeue in the empty state and failed removal case'

        queue.enqueue(FIRST_VALUE)
        queue.enqueue(SECOND_VALUE)
        queue.enqueue(THIRD_VALUE)
        assert queue.peek() == FIRST_VALUE :
                'Queue should expose the first value in the FIFO and non-mutating peek case'
        assert queue.size == 3 :
                'Queue should preserve size after peek in the FIFO and non-mutating peek case'

        assert queue.dequeue() == FIRST_VALUE :
                'Queue should remove the front value in the removal and reuse case'
        queue.enqueue(REUSED_VALUE)
        assert queue.dequeue() == SECOND_VALUE :
                'Queue should preserve FIFO order in the removal and reuse case'
        assert queue.dequeue() == THIRD_VALUE :
                'Queue should preserve FIFO order for the third value in the removal and reuse case'
        assert queue.dequeue() == REUSED_VALUE :
                'Queue should remove the reused rear value in the removal and reuse case'
        assert queue.isEmpty() :
                'Queue should report empty after the removal and reuse case'
        assert queue.size == EMPTY_SIZE :
                'Queue should have size zero after the removal and reuse case'

        assert queue.dequeue() == FAILED_VALUE :
                'Queue should return the failure indicator in the empty after removal case'
        assert queue.isEmpty() :
                'Queue should remain empty in the empty after removal case'
    }

    def "Node should satisfy all cases"() {
        expect:
        assertNodeCases()
    }

    def "LinkedList should satisfy all cases"() {
        expect:
        assertLinkedListCases(new LinkedList())
    }

    def "Stack should satisfy all cases"() {
        expect:
        assertStackCases(new Stack())
    }

    def "Queue should satisfy all cases"() {
        expect:
        assertQueueCases(new Queue())
    }
}
