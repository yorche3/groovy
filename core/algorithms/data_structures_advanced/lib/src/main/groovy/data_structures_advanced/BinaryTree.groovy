package data_structures_advanced

import groovy.transform.CompileStatic

@CompileStatic
class BinaryTree {

    private TreeNode root
    private int count = 0

    BinaryTree() {
    }

    boolean insert(Integer value) {
        if (root == null) {
            root = new TreeNode(value)
            count++
            return true
        }
        TreeNode current = root
        while (true) {
            if (value < current.getValue()) {
                if (current.getLeft() == null) {
                    current.setLeft(new TreeNode(value))
                    count++
                    return true
                }
                current = current.getLeft()
            } else if (value > current.getValue()) {
                if (current.getRight() == null) {
                    current.setRight(new TreeNode(value))
                    count++
                    return true
                }
                current = current.getRight()
            } else {
                return true
            }
        }
    }

    boolean contains(Integer value) {
        TreeNode current = root
        while (current != null) {
            int cmp = value <=> current.getValue()
            if (cmp == 0) {
                return true
            }
            current = cmp < 0 ? current.getLeft() : current.getRight()
        }
        return false
    }

    boolean isEmpty() {
        return count == 0
    }

    int getSize() {
        return count
    }
}
