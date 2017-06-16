class CountingSort {
    fun sort(array: Array<Int>) {
        val count = Array(findMax((array)) + 1, { 0 })
        for (i in array) {
            count[i]++
        }

        var index = 0
        for (c in 0 until count.size) {
            for (d in 0 until count[c]) {
                array[index] = c
                index++
            }
        }
    }

    private fun findMax(array: Array<Int>): Int{
        var max = array[0]
        for (i in array) {
            if (i > max)
                max = i
        }
        return max
    }
}