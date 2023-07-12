package hyewon.BinarySearch

import java.io.*

fun lowerBound(arr: ArrayList<Int>, key:Int) : Int {
    var lo = 0
    var hi = arr.size

    while (lo < hi) {
        val mid = (lo + ((hi-lo) / 2))
        if (key <= arr[mid]) { //이상 조건
            hi = mid
        } else {
            lo = mid+1
        }
    }
    return lo
}
fun upperBound(arr : ArrayList<Int>, key:Int) : Int {
    var lo = 0
    var hi = arr.size

    while (lo < hi) {
        val mid = (lo + ((hi - lo)/2))
        if (key < arr[mid]) {
            hi = mid
        } else {
            lo = mid + 1
        }
    }
    return lo
}
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = arrayListOf<Int>()
    val s = br.readLine().split(" ")
    for (i in 0 until n) {
        arr.add(s[i].toInt())
    }
    arr.sort()
    val n2 = br.readLine()!!.toInt()
    val s2 = br.readLine().split(" ")
    val sb =StringBuilder()
    for (j in 0 until n2) {
        val key = s2[j].toInt()
        sb.append(upperBound(arr,key) - lowerBound(arr,key)).append(" ")
    }
    println(sb)
}
