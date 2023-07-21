package hyewon.BinarySearch

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val line = StringTokenizer(br.readLine())
    val k = line.nextToken().toInt()
    val num = line.nextToken().toInt()

    val arr = Array(k){0L}
    for(i in 0 until k) {
        arr[i] = br.readLine().toLong()
    }

    var lo = 1L
    var hi = arr.max()
    var ans = 0L

    while(lo<=hi) {
        val mid = (lo+hi)/2L
        var cnt = 0L

        arr.forEach { cnt+=it/mid }

        if(cnt>=num) {
            ans = mid

            lo = mid + 1
        } else {
            hi = mid -1
        }
    }

    bw.write("$ans")
    bw.flush()
    bw.close()
}