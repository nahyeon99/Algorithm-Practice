package hyewon.BinarySearch

import java.util.*
import kotlin.collections.ArrayList

fun main() = with(Scanner(System.`in`)){
    val n = nextInt()
    val arr = mutableSetOf<Long>()
    val arr2 = ArrayList<Long>()
    for(i in 0 until n) arr.add(nextLong())
    val m = nextInt()
    for(i in 0 until m) arr2.add(nextLong())

    for(i in 0 until m){
        if(arr.contains(arr2[i])){
            println(1)
        }
        else println(0)
    }
}