class HeapSort {
    fun <T : Comparable<T>> sort(array: Array<T>) {
        val parent = (array.size - 2) / 2 // parent of the last element in the list
        for (p in parent downTo 0)
            heapify(array, array.size, p)

        for (i in array.size - 1 downTo 0) {
            val temp = array[0]
            array[0] = array[i]
            array[i] = temp
            // Heapify from the root
            heapify(array, i, 0)
        }

    }

    private fun <T : Comparable<T>> heapify(array: Array<T>, size: Int, parent: Int) {
        var largest = parent
        val left = 2 * parent + 1 // left child of parent
        val right = 2 * parent + 2 // right child of parent

        if (left < size && array[left] > array[largest])
            largest = left
        if (right < size && array[right] > array[largest])
            largest = right

        if (largest != parent) {
            val temp = array[parent]
            array[parent] = array[largest]
            array[largest] = temp
            heapify(array, size, largest)
        }
    }
}