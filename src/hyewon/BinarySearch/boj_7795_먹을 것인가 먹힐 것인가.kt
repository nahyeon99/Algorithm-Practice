package hyewon.BinarySearch

import java.io.*

private lateinit var A: IntArray
private lateinit var B: IntArray

fun main()  {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))


    repeat(br.readLine().toInt()) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        A = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        B = br.readLine().split(" ").map { it.toInt() }.sorted().toIntArray()

        var ans = 0

        for (e in A) {
            ans += lowerBound(e)
        }

        bw.write("$ans\n")
    }

    bw.flush()
    bw.close()
}

private fun lowerBound(target: Int): Int {

    var L = 0
    var R = B.lastIndex

    while (L <= R) { //L > R 되는 순간을 찾기 ->
        val mid = (L + R) / 2
        if (B[mid] < target) {
            L = mid + 1
        } else {
            R = mid - 1
        }
    }

    return L
}
