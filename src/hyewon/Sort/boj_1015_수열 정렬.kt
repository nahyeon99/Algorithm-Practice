package hyewon.Sort

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val p = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val ans = IntArray(n)
    for (i in 0 until n) {
        for (j in 0 until i) {
            if (p[j] > p[i]) {
                ans[j]++
            } else if (p[j] <= p[i]) {
                ans[i]++
            }
        }
    }
    for (idx in 0 until n) {
        bw.write("${ans[idx]} ")
        bw.flush()
    }

    bw.close()
}