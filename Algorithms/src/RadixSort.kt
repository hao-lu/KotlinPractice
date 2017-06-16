class RadixSort {
    val BASE = 10

    fun sort(array: Array<Int>) {
        val buckets = MutableList(BASE, { mutableListOf<Int>()})
        var factor = 1
        for (n in 1..getNumberOfPlaceValue(array)) {
            val output = Array(array.size, { i -> array[i]})
            // Places the number in the corresponding "bucket"
            for (o in output) {
                buckets[(o / factor) % BASE].add(o)
            }
            factor *= BASE

            // Update array list
            var index = 0
            while (index < array.size) {
                for (b in buckets) {
                    for (e in b) {
                        array[index] = e
                        index++
                    }
                }
            }

            // Empty buckets
            for (b in buckets) {
                b.clear()
            }
        }

    }

    private fun getNumberOfPlaceValue(array: Array<Int>): Int {
        var max = array[0]
        for (i in array) {
            if (i > max)
                max = i
        }

        var placeValue = 0
        do {
            max /= 10
            placeValue++
        } while(max > 0)

        return placeValue
    }
}

