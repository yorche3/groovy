package data_structures_advanced

import groovy.transform.CompileStatic

@CompileStatic
abstract class Node {
    private Integer value

    protected Node(Integer value) {
        this.value = value
    }

    Integer getValue() {
        return this.value
    }
}
