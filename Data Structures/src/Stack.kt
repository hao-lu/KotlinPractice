
class Stack<E> {
    private data class Node<E> (var mData: E, var mNext: Stack.Node<E>? = null)

    private var mHead: Stack.Node<E>? = null

    fun push(data: E) {
        val node = Stack.Node(data, null)
        if (mHead == null) {
            mHead = node
        }
        else {
            node.mNext = mHead
            mHead = node
        }
    }

    fun pop(): E? {
        val data = mHead?.mData
        mHead = mHead?.mNext
        return data
    }

    fun peek(): E? {
        return mHead?.mData
    }

    fun empty() {
        mHead = null
    }

    fun print() {
        if (mHead != null) {
            var curr = mHead
            do {
                println(curr?.mData.toString())
                curr = curr?.mNext
            } while (curr?.mNext != null)
            println(curr?.mData.toString())
        }
    }

}