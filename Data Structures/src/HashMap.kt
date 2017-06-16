class HashMap<K,V> (size: Int = 0) {
    private data class Node<K,V>(var mKey: K, var mValue: V, var mNext: HashMap.Node<K, V>?)

    private var mSize: Int = 0
    // Size the initial size of the HashMap
    private val mTable: Array<HashMap.Node<K, V>?> = arrayOfNulls<HashMap.Node<K, V>>(size)

    fun put(key: K, value: V) {
        val hash: Int = key!!.hashCode()
        val index = Math.abs(hash % mTable.size)

        var node: HashMap.Node<K, V>? = mTable[index]
        // Check if the value is already in the HashMap, if it is then return
        while (node != null) {
            if (node.mValue!! == value) {
                return
            }
            node = node.mNext
        }

        // This adds the new node to the beginning
//        val n: Node<K,V>? = mTable[index]
//        val insert: Node<K,V>  = Node(key, value, n)
//        mTable[index] = insert

        // This adds the new node to the end
        val insert: HashMap.Node<K, V> = HashMap.Node(key, value, null)
        // Check if it's the first element in the index location
        if (mTable[index] == null)
            mTable[index] = insert
        else
            node?.mNext = insert
        mSize++

    }

    fun get(key: K): V? {
        val hash: Int = key!!.hashCode()
        val index = Math.abs(hash % mTable.size)

        var node = mTable[index]
        // Check if the value is already in the HashMap, if it is then return
        while (node != null) {
            if (node.mKey!! == key) {
                return node.mValue
            }
            node = node.mNext
        }
        return null
    }

    fun remove(key: K): V? {
        val hash: Int = key!!.hashCode()
        val index = Math.abs(hash % mTable.size)

        if (mTable[index]?.mKey == key) {
            val found = mTable[index]?.mValue
            mTable[index] = null
            mSize--
            return found
        }
        else {
            var node = mTable[index]
            while (node != null) {
                if (node.mNext?.mKey == key) {
                    val found = node.mNext?.mValue
                    // If the mNext has something
                    if (node.mNext?.mNext != null) {
                        node.mNext = node.mNext?.mNext
                    }
                    else {
                        node.mNext = null
                    }
                    mSize--
                    return found
                }
                node = node.mNext
            }
        }
        return null
    }

    fun containsKey(key: K): Boolean {
        val hash: Int = key!!.hashCode()
        val index = Math.abs(hash % mTable.size)

        var node = mTable[index]
        // Check if the value is already in the HashMap, if it is then return
        while (node != null) {
            if (node.mKey!! == key) {
                return true
            }
            node = node.mNext
        }
        return false
    }

    fun containsValue(value: V): Boolean {
        for (index in 0 until mTable.size) {
            var node = mTable[index]
            // Check if the value is already in the HashMap, if it is then return
            while (node != null) {
                if (node.mValue!! == value) {
                    return true
                }
                node = node.mNext
            }
        }
        return false
    }

    fun size(): Int {
        return mSize
    }
}