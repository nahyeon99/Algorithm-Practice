package hyewon.TwoPointers

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val num = br.readLine().toInt()
    val arr = IntArray(num)
    val line = StringTokenizer(br.readLine())
    for(i in 0 until num) {
        arr[i] = line.nextToken().toInt()
    }
    arr.sort()
    var (sum, cnt, start, end) = arrayOf(br.readLine().toInt(), 0, 0, num -1)
    var tmp : Int

    while (start < end) {
        tmp = arr[start] + arr[end]
        if (tmp == sum) {
            cnt++
        }
        if (tmp <= sum) {
            start++
        } else {
            end--
        }
    }

    bw.write("$cnt")
    bw.flush()
    bw.close()
    br.close()
}