class Queue<E> {
    private data class Node<E> (var mData: E, var mNext: Node<E>? = null)

    private var mHead: Node<E>? = null

    fun add(data: E) {
        val node = Node(data, null)
        if (mHead == null) {
            mHead = node
        }
        else {
            var curr = mHead
            while (curr?.mNext != null) {
                curr = curr.mNext
            }
            curr?.mNext = node
        }
    }

    fun peek(): E? {
        return mHead?.mData
    }

    fun remove(): E? {
        val data = mHead?.mData
        mHead = mHead?.mNext
        return data
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