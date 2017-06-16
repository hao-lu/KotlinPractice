class BinarySearchTree<in E: Comparable<E>> {
    private data class Node<E> (var mData: E, var mLeft: BinarySearchTree.Node<E>?, var mRight: BinarySearchTree.Node<E>?)
    private var root: BinarySearchTree.Node<E>? = null

    fun find(data: E): Boolean  {
        var curr = root
        while (curr != null) {
            if (curr.mData == data)
                return true
            else if (curr.mData < data) {
                curr = curr.mRight
            }
            else {
                curr = curr.mLeft
            }
        }
        return false
    }

    fun insert(data: E) {
        var insert = BinarySearchTree.Node(data, null, null)
        if (root == null) {
            root = insert
            println("insert root " + data)
            return
        }
        var curr = root
        while (true) {
            if (curr!!.mData < data) {
                if (curr.mRight == null) {
                    curr.mRight = insert
                    println("insert right " + data)
                    return
                }
                curr = curr.mRight
            }
            else if (curr.mData > data) {
                if (curr.mLeft == null) {
                    curr.mLeft = insert
                    println("insert left " + data)
                    return
                }
                curr = curr.mLeft
            }
            else
                return
        }

    }

    fun remove(data: E): Boolean {
        if (root!!.mData == data)
            root = null
        var curr = root
        var parent = curr
        while (curr?.mData != data) {
            parent = curr
            if (curr!!.mData < data)
                curr = curr.mRight
            else if (curr.mData > data)
                curr = curr.mLeft
        }
        // Case 1: If no children
        if (curr.mLeft == null && curr.mRight == null) {
            if (parent?.mLeft?.mData == data) {
                parent.mLeft = null
            }
            else
                parent?.mRight = null
        }
        // Case 2: If two children
        else if (curr.mLeft != null && curr.mRight != null) {
            // Find the largest left
            var largestLeft = curr.mLeft
            var largestLeftParent = largestLeft
            while (largestLeft?.mRight != null) {
                largestLeftParent = largestLeft
                largestLeft = largestLeft.mRight
            }
            // Largest left parent changed to null
            largestLeftParent?.mRight = null
            // Largest left is now in the curr position with curr's children
            largestLeft?.mLeft = curr.mLeft
            largestLeft?.mRight = curr.mRight
            // Check if curr node is left or right node
            if (parent?.mLeft?.mData == data) {
                parent.mLeft = largestLeft
            }
            else {
                parent?.mRight = largestLeft
            }
        }
        // Case 3: If one child
        else {
            if (curr.mLeft != null) {
                if (parent?.mLeft?.mData == data) {
                    parent.mLeft = curr.mLeft
                }
                else {
                    parent?.mRight = curr.mLeft
                }
            }
            else {
                if (parent?.mLeft?.mData == data) {
                    parent.mLeft = curr.mRight
                }
                else {
                    parent?.mRight = curr.mRight
                }
            }
        }
        return true
    }

    // Pre-order traversal: me, left, right
    fun preOrder() {
        preOrder(root)
    }

    private fun preOrder(node: BinarySearchTree.Node<E>?) {
        if (node == null)
            return
        print("${node.mData} ")
        preOrder(node.mLeft)
        preOrder(node.mRight)
    }

    // In-order traversal: left, me, right
    fun inOrder() {
        inOrder(root)
    }

    private fun inOrder(node: BinarySearchTree.Node<E>?) {
        if (node == null)
            return
        inOrder(node.mLeft)
        print("${node.mData} ")
        inOrder(node.mRight)
    }

    // Post-order traversal: left, right, me
    fun postOrder() {
        postOrder(root)
    }

    private fun postOrder(node: BinarySearchTree.Node<E>?) {
        if (node == null)
            return
        postOrder(node.mLeft)
        postOrder(node.mRight)
        print("${node.mData} ")
    }

}