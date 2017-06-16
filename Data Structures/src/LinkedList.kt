class LinkedList<E> {
    private data class Node<E> (var mData: E, var mNext: LinkedList.Node<E>? = null)

    private var mSize: Int = 0
    private var mHead: LinkedList.Node<E>? = null

    fun add(data: E) {
        val node = LinkedList.Node(data, null)
        if (mSize == 0) {
            mHead = node
        }
        else {
            var curr = mHead
            while (curr?.mNext != null) {
                curr = curr.mNext
            }
            curr?.mNext = node
        }
        mSize++
    }

    fun remove(index: Int): E? {
        if (index < 0 || index >= mSize)
            throw IndexOutOfBoundsException()
        else {
            var curr = mHead
            for (i in 0 until index - 1) {
                curr = curr?.mNext
            }
            // The removed mData to be returned
            val ret = curr?.mNext?.mData
            // The node the removed mData is pointing to
            val temp = curr?.mNext?.mNext
            curr?.mNext = temp
            mSize--
            return ret
        }
    }

    fun get(index: Int): E? {
        if (index < 0 || index >= mSize)
            throw IndexOutOfBoundsException()
        else {
            var curr = mHead
            for (i in 0 until index - 1) {
                curr = curr?.mNext
            }
            // The target mData to be returned
            return curr?.mNext?.mData
        }
    }

    fun size(): Int {
        return mSize
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