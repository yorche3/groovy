package data_structures_advanced

import spock.lang.Specification

class DataStructuresAdvancedTest extends Specification {

    static final Integer PARENT_VALUE = 10
    static final Integer LEFT_VALUE = 20
    static final Integer RIGHT_VALUE = 30

    static final Integer ROOT_KEY = 50
    static final Integer LOWER_KEY = 30
    static final Integer HIGHER_KEY = 70
    static final Integer LOWER_LEAF_KEY = 20
    static final Integer MIDDLE_LEAF_KEY = 40
    static final Integer ABSENT_KEY = 99
    static final int EMPTY_SIZE = 0

    static final Integer LABEL_TEN = 10
    static final Integer LABEL_THIRTY = 30
    static final Integer LABEL_FIFTY = 50
    static final Integer LABEL_SEVENTY = 70
    static final Integer MISSING_LABEL = 99
    static final Integer OTHER_MISSING_LABEL = 98

    private static TreeNode linkedParent() {
        TreeNode parent = new TreeNode(PARENT_VALUE)
        parent.setLeft(new TreeNode(LEFT_VALUE))
        parent.setRight(new TreeNode(RIGHT_VALUE))
        return parent
    }

    private static BinaryTree treeWith(List<Integer> values, String caseName) {
        BinaryTree tree = new BinaryTree()
        values.each { Integer value ->
            assert tree.insert(value) :
                    "BinaryTree should succeed inserting ${value} in the ${caseName} case"
        }
        return tree
    }

    private static Graph graphWith(List<Integer> labels, String caseName) {
        Graph graph = new Graph()
        labels.each { Integer label ->
            assert graph.addVertex(label) :
                    "Graph should succeed registering ${label} in the ${caseName} case"
        }
        return graph
    }

    def "TreeNode should create a tree node"() {
        when:
        TreeNode node = new TreeNode(PARENT_VALUE)

        then:
        node.getValue() == PARENT_VALUE
    }

    def "TreeNode should expose absent initial links"() {
        when:
        TreeNode node = new TreeNode(PARENT_VALUE)

        then:
        node.getLeft() == null
        node.getRight() == null
    }

    def "TreeNode should link two children"() {
        when:
        TreeNode parent = linkedParent()

        then:
        parent.getLeft()?.getValue() == LEFT_VALUE
        parent.getRight()?.getValue() == RIGHT_VALUE
    }

    def "TreeNode should traverse each link"() {
        when:
        TreeNode parent = linkedParent()
        TreeNode left = parent.getLeft()
        TreeNode right = parent.getRight()

        then:
        left?.getValue() == LEFT_VALUE
        right?.getValue() == RIGHT_VALUE
        left?.getLeft() == null
        left?.getRight() == null
        right?.getLeft() == null
        right?.getRight() == null
    }

    def "TreeNode should unlink children"() {
        given:
        TreeNode parent = linkedParent()

        when:
        parent.setLeft(null)

        then:
        parent.getValue() == PARENT_VALUE
        parent.getLeft() == null
        parent.getRight()?.getValue() == RIGHT_VALUE

        when:
        parent.setRight(null)

        then:
        parent.getValue() == PARENT_VALUE
        parent.getLeft() == null
        parent.getRight() == null
    }

    def "BinaryTree should be empty on creation"() {
        when:
        BinaryTree tree = new BinaryTree()

        then:
        tree.isEmpty()
        tree.getSize() == EMPTY_SIZE
        !tree.contains(ROOT_KEY)
    }

    def "BinaryTree should insert the root"() {
        when:
        BinaryTree tree = treeWith([ROOT_KEY], 'insert the root')

        then:
        tree.getSize() == 1
        !tree.isEmpty()
        tree.contains(ROOT_KEY)
    }

    def "BinaryTree should insert lower and higher values"() {
        when:
        BinaryTree tree = treeWith([ROOT_KEY, LOWER_KEY, HIGHER_KEY], 'insert lower and higher')

        then:
        tree.getSize() == 3
        tree.contains(ROOT_KEY)
        tree.contains(LOWER_KEY)
        tree.contains(HIGHER_KEY)
    }

    def "BinaryTree should keep multilevel branches"() {
        when:
        List<Integer> values = [ROOT_KEY, LOWER_KEY, HIGHER_KEY, LOWER_LEAF_KEY, MIDDLE_LEAF_KEY]
        BinaryTree tree = treeWith(values, 'multilevel branches')

        then:
        values.every { Integer value -> tree.contains(value) }
        tree.getSize() == 5
    }

    def "BinaryTree should fail on a missing value in a nonempty tree"() {
        when:
        BinaryTree tree = treeWith([ROOT_KEY], 'missing value in nonempty tree')

        then:
        !tree.contains(ABSENT_KEY)
        tree.getSize() == 1
        tree.contains(ROOT_KEY)
    }

    def "BinaryTree should treat a duplicate as idempotent"() {
        when:
        BinaryTree tree = treeWith([ROOT_KEY, LOWER_KEY, HIGHER_KEY, LOWER_KEY], 'idempotent duplicate')

        then:
        tree.getSize() == 3
        tree.contains(ROOT_KEY)
        tree.contains(LOWER_KEY)
        tree.contains(HIGHER_KEY)
    }

    def "BinaryTree should accept ordered insertions"() {
        when:
        List<Integer> values = [LOWER_LEAF_KEY, LOWER_KEY, MIDDLE_LEAF_KEY, ROOT_KEY, HIGHER_KEY]
        BinaryTree tree = treeWith(values, 'ordered insertions')

        then:
        tree.getSize() == 5
        values.every { Integer value -> tree.contains(value) }
        !tree.contains(ABSENT_KEY)
    }

    def "Graph should be empty on creation"() {
        when:
        Graph graph = new Graph()

        then:
        graph.isEmpty()
        graph.getVertexCount() == 0
        graph.getEdgeCount() == 0
        !graph.hasEdge(LABEL_TEN, LABEL_THIRTY)
        graph.getNeighbors(LABEL_TEN) == null
    }

    def "Graph should hold an isolated vertex"() {
        when:
        Graph graph = graphWith([LABEL_TEN], 'isolated vertex')

        then:
        !graph.isEmpty()
        graph.getVertexCount() == 1
        graph.getEdgeCount() == 0
        graph.getNeighbors(LABEL_TEN) != null
        graph.getNeighbors(LABEL_TEN).isEmpty()
    }

    def "Graph should keep a directed edge between nonconsecutive labels"() {
        given:
        Graph graph = graphWith([LABEL_TEN, LABEL_SEVENTY], 'nonconsecutive labels')

        expect:
        graph.addEdge(LABEL_TEN, LABEL_SEVENTY)
        graph.hasEdge(LABEL_TEN, LABEL_SEVENTY)
        !graph.hasEdge(LABEL_SEVENTY, LABEL_TEN)
        graph.getVertexCount() == 2
        graph.getEdgeCount() == 1
    }

    def "Graph should preserve adjacency on a duplicate vertex"() {
        given:
        Graph graph = graphWith([LABEL_TEN, LABEL_THIRTY], 'duplicate vertex')

        expect:
        graph.addEdge(LABEL_TEN, LABEL_THIRTY)
        graph.addVertex(LABEL_TEN)
        graph.getVertexCount() == 2
        graph.getEdgeCount() == 1
        graph.getNeighbors(LABEL_TEN) == [LABEL_THIRTY]
    }

    def "Graph should treat a duplicate edge as idempotent"() {
        given:
        Graph graph = graphWith([LABEL_TEN, LABEL_THIRTY], 'duplicate edge')

        expect:
        graph.addEdge(LABEL_TEN, LABEL_THIRTY)
        graph.addEdge(LABEL_TEN, LABEL_THIRTY)
        graph.getVertexCount() == 2
        graph.getEdgeCount() == 1
        graph.getNeighbors(LABEL_TEN) == [LABEL_THIRTY]
    }

    def "Graph should reject a missing endpoint without mutation"() {
        given:
        Graph graph = graphWith([LABEL_TEN, LABEL_THIRTY], 'missing endpoint')
        assert graph.addEdge(LABEL_TEN, LABEL_THIRTY)

        expect:
        !graph.addEdge(LABEL_TEN, MISSING_LABEL)
        !graph.addEdge(MISSING_LABEL, LABEL_TEN)
        !graph.addEdge(OTHER_MISSING_LABEL, MISSING_LABEL)
        !graph.addEdge(MISSING_LABEL, MISSING_LABEL)
        graph.getVertexCount() == 2
        graph.getEdgeCount() == 1
        graph.getNeighbors(LABEL_TEN) == [LABEL_THIRTY]
        graph.getNeighbors(LABEL_THIRTY) != null
        graph.getNeighbors(LABEL_THIRTY).isEmpty()
        !graph.hasEdge(LABEL_TEN, MISSING_LABEL)
        !graph.hasEdge(MISSING_LABEL, LABEL_TEN)
        !graph.hasEdge(OTHER_MISSING_LABEL, MISSING_LABEL)
        !graph.hasEdge(MISSING_LABEL, MISSING_LABEL)
        graph.getNeighbors(OTHER_MISSING_LABEL) == null
        graph.getNeighbors(MISSING_LABEL) == null
    }

    def "Graph should list sorted neighbours and counts"() {
        given:
        Graph graph = graphWith([LABEL_TEN, LABEL_THIRTY, LABEL_FIFTY, LABEL_SEVENTY], 'sorted neighbours')

        expect:
        graph.addEdge(LABEL_TEN, LABEL_SEVENTY)
        graph.addEdge(LABEL_TEN, LABEL_THIRTY)
        graph.addEdge(LABEL_TEN, LABEL_FIFTY)
        graph.addEdge(LABEL_THIRTY, LABEL_FIFTY)
        graph.getNeighbors(LABEL_TEN) == [LABEL_THIRTY, LABEL_FIFTY, LABEL_SEVENTY]
        graph.getNeighbors(LABEL_THIRTY) == [LABEL_FIFTY]
        graph.getNeighbors(LABEL_FIFTY) != null
        graph.getNeighbors(LABEL_FIFTY).isEmpty()
        graph.getNeighbors(LABEL_SEVENTY) != null
        graph.getNeighbors(LABEL_SEVENTY).isEmpty()
        graph.getVertexCount() == 4
        graph.getEdgeCount() == 4
    }

    def "Graph should fail a missing-edge query"() {
        given:
        Graph graph = graphWith([LABEL_TEN, LABEL_THIRTY], 'missing-edge query')

        expect:
        !graph.hasEdge(LABEL_TEN, LABEL_THIRTY)
        graph.getVertexCount() == 2
        graph.getEdgeCount() == 0
        !graph.isEmpty()
    }

    def "Graph should distinguish failure from empty neighbours of a missing vertex"() {
        given:
        Graph graph = graphWith([LABEL_TEN], 'missing vertex neighbours')

        expect:
        graph.getNeighbors(MISSING_LABEL) == null
        graph.getNeighbors(LABEL_TEN) != null
        graph.getNeighbors(LABEL_TEN).isEmpty()
        graph.getVertexCount() == 1
        graph.getEdgeCount() == 0
    }

    def "Graph should accept a self-loop and its duplicate"() {
        given:
        Graph graph = graphWith([LABEL_TEN], 'self-loop and duplicate')

        expect:
        graph.addEdge(LABEL_TEN, LABEL_TEN)
        graph.addEdge(LABEL_TEN, LABEL_TEN)
        graph.hasEdge(LABEL_TEN, LABEL_TEN)
        graph.getNeighbors(LABEL_TEN) == [LABEL_TEN]
        graph.getVertexCount() == 1
        graph.getEdgeCount() == 1
    }

    def "Graph should isolate the neighbour result from the graph"() {
        given:
        Graph graph = graphWith([LABEL_TEN, LABEL_THIRTY, LABEL_FIFTY], 'neighbour-result isolation')
        assert graph.addEdge(LABEL_TEN, LABEL_THIRTY)
        List<Integer> saved = graph.getNeighbors(LABEL_TEN)

        when:
        List<Integer> copy = graph.getNeighbors(LABEL_TEN)
        try {
            copy.add(LABEL_SEVENTY)
        } catch (UnsupportedOperationException ignored) {
            // an immutable result already guarantees isolation
        }

        then:
        graph.getNeighbors(LABEL_TEN) == [LABEL_THIRTY]

        when:
        graph.addEdge(LABEL_TEN, LABEL_FIFTY)

        then:
        saved == [LABEL_THIRTY]
        graph.getNeighbors(LABEL_TEN) == [LABEL_THIRTY, LABEL_FIFTY]
        graph.getVertexCount() == 3
        graph.getEdgeCount() == 2
    }
}
