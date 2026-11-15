package data_structures_advanced

import groovy.transform.CompileStatic

@CompileStatic
class TreeNode extends Node {

    private TreeNode left
    private TreeNode right

    TreeNode(Integer value) {
        super(value)
    }

    TreeNode getLeft() {
        return left
    }

    TreeNode getRight() {
        return right
    }

    void setLeft(TreeNode node) {
        this.left = node
    }

    void setRight(TreeNode node) {
        this.right = node
    }
}
