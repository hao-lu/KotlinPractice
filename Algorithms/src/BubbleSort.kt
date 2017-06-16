class BubbleSort {
    fun <T : Comparable<T>> sort(array: Array<T>) {
        var swap: Boolean = true
        while (swap) {
            swap = false
            for (i in 1 until array.size) {
                if (array[i] < array[i - 1]) {
                    val temp = array[i]
                    array[i] = array[i - 1]
                    array[i - 1] = temp
                    swap = true
                }
            }
        }
    }
}