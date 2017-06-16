import java.util.*
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val nums = Array(100000) { Random().nextInt(1000) }

//    for (i in nums) {
//        print("$i ")
//    }
//    println()
//
//    val algorithm = QuickSort()
//    val executionTime = measureTimeMillis { algorithm.sort(nums) }
//
//    for (i in nums) {
//        print("$i ")
//    }
//
//    println("\n$executionTime milliseconds")


    val algorithm = InsertionSort()
    var executionTime = measureTimeMillis { algorithm.sort(nums) }
    println("InsertionSort : $executionTime milliseconds")

    val algorithm1 = SelectionSort()
    executionTime = measureTimeMillis { algorithm1.sort(nums) }
    println("SelectionSort : $executionTime milliseconds")

    val algorithm2 = CountingSort()
    executionTime = measureTimeMillis { algorithm2.sort(nums) }
    println("CountingSort : $executionTime milliseconds")

    val algorithm3 = RadixSort()
    executionTime = measureTimeMillis { algorithm3.sort(nums) }
    println("RadixSort : $executionTime milliseconds")

    val algorithm4 = MergeSort()
    executionTime = measureTimeMillis { algorithm4.sort(nums) }
    println("MergeSort : $executionTime milliseconds")

    val algorithm5 = HeapSort()
    executionTime = measureTimeMillis { algorithm5.sort(nums) }
    println("HeapSort : $executionTime milliseconds")

    val algorithm6 = QuickSort()
    executionTime = measureTimeMillis { algorithm6.sort(nums) }
    println("QuickSort : $executionTime milliseconds")


}