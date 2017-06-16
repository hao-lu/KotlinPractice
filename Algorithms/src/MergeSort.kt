class MergeSort {
    fun <T : Comparable<T>> sort(array: Array<T>) {
        mergeSort(array, 0, array.size - 1)
    }

    private fun <T : Comparable<T>> mergeSort(array: Array<T>, left: Int, right: Int) {
        if (right <= left) return
        val mid = (left + right) / 2
        mergeSort(array, left, mid) // left
        mergeSort(array, mid + 1, right) // right
        merge(array, left, mid, right)
    }

    private fun <T : Comparable<T>> merge(array: Array<T>, left: Int, mid: Int, right: Int) {
        val temp = array.copyOf()

        var i = left // start of the left half
        var j = mid + 1 // start of the right half
        for (k in left..right) {
            // If all the left half elements have been added
            if (i > mid)
                array[k] = temp[j++]
            // If all the right half elements have been added
            else if (j > right)
                array[k] = temp[i++]
            // If the right half element is smaller than the left half element
            else if (temp[i] > temp[j])
                array[k] = temp[j++]
            // If the left half element is smaller than the right half element
            else if (temp[i] < temp[j])
                array[k] = temp[i++]
        }
    }

}