package data_structures_advanced

import groovy.transform.CompileStatic

@CompileStatic
class TreeNode extends Node {
    TreeNode(Integer value) {
        super(value)
    }

    TreeNode getLeft() {
        return null
    }

    TreeNode getRight() {
        return null
    }

    void setLeft(TreeNode node) {
    }

    void setRight(TreeNode node) {
    }
}
