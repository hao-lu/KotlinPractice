class InsertionSort {
    fun <T : Comparable<T>> sort(array: Array<T>) {
        for (i in 1 until array.size) {
            for (j in i downTo 1) {
                if (array[j - 1] < array[j])
                    break
                val temp = array[j]
                array[j] = array[j - 1]
                array[j - 1] = temp
            }
        }
    }
}