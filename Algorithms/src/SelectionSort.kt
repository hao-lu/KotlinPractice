class SelectionSort {
    fun <T : Comparable<T>> sort(array: Array<T>) {
        for (i in 0 until array.size) {
            var min = i
            for (j in i until array.size) {
                if (array[min] > array[j]) {
                    min = j
                }
            }
            val temp = array[i]
            array[i] = array[min]
            array[min] = temp
        }
    }
}