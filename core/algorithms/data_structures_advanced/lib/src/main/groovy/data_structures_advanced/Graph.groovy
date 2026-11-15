package data_structures_advanced

import groovy.transform.CompileStatic

@CompileStatic
class Graph {

    private GraphNode vertices = null
    private int vertexCount = 0
    private int edgeCount = 0

    Graph() {
    }

    private GraphNode findVertex(Integer label) {
        GraphNode current = vertices
        while (current != null) {
            if (current.getValue() == label) {
                return current
            }
            current = current.nextVertex
        }
        return null
    }

    boolean addVertex(Integer label) {
        if (findVertex(label) != null) {
            return true
        }
        GraphNode newVertex = new GraphNode(label)
        newVertex.nextVertex = vertices
        vertices = newVertex
        vertexCount++
        return true
    }

    boolean addEdge(Integer u, Integer v) {
        GraphNode vertexU = findVertex(u)
        if (vertexU == null || findVertex(v) == null) {
            return false
        }
        List<Integer> neighbors = vertexU.neighbors
        if (neighbors.contains(v)) {
            return true
        }
        int position = 0
        while (position < neighbors.size() && neighbors.get(position).compareTo(v) < 0) {
            position++
        }
        neighbors.add(position, v)
        edgeCount++
        return true
    }

    boolean hasEdge(Integer u, Integer v) {
        GraphNode vertexU = findVertex(u)
        if (vertexU == null || findVertex(v) == null) {
            return false
        }
        return vertexU.neighbors.contains(v)
    }

    List<Integer> getNeighbors(Integer u) {
        GraphNode vertexU = findVertex(u)
        if (vertexU == null) {
            return null
        }
        return new ArrayList<Integer>(vertexU.neighbors)
    }

    boolean isEmpty() {
        return vertexCount == 0
    }

    int getVertexCount() {
        return vertexCount
    }

    int getEdgeCount() {
        return edgeCount
    }
}
