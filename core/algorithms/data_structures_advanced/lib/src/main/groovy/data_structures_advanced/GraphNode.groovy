package data_structures_advanced

import groovy.transform.CompileStatic
import groovy.transform.PackageScope

@CompileStatic
@PackageScope
class GraphNode extends Node {

    List<Integer> neighbors = []
    GraphNode nextVertex = null

    GraphNode(Integer label) {
        super(label)
    }
}
