class QuickSort {
    fun <T : Comparable<T>> sort(array: Array<T>) {
        quickSort(array, 0, array.size)
    }

    private fun <T : Comparable<T>> quickSort(array: Array<T>, left: Int, right: Int) {
        if (left < right) {
            val s = parition(array, left, right)
            quickSort(array, left, s)
            quickSort(array, s + 1, right)
        }
    }

    private fun <T : Comparable<T>> parition(array: Array<T>, left: Int, right: Int): Int {
        val pivot = median(array, left, right)
        swap(array, pivot, right - 1)

        var s = left
        for (i in s until right) {
            if (array[i] < array[right - 1]) {
                swap(array, s, i)
                s++
            }
        }
        swap(array, right - 1, s)
        return s
    }

    private fun <T : Comparable<T>> median(array: Array<T>, left: Int, right: Int): Int {
        val mid = (left + right) / 2
        if (array[left] < array[mid]) {
            if (array[right - 1] < array[left])
                return left
        } else {
            if (array[right - 1] < array[mid])
                return mid
            else if (array[left] < array[right - 1])
                return left
        }
        return right - 1
    }

    private fun <T : Comparable<T>> swap(array: Array<T>, s: Int, i: Int) {
        val temp = array[s]
        array[s] = array[i]
        array[i] = temp
    }
}