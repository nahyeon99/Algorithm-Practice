package hyewon.BinarySearch

import java.io.*
import kotlin.math.absoluteValue

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val nArray = br.readLine().split(" ").map { it.toInt() }.sorted().toIntArray()

    var bestSum = Int.MAX_VALUE
    var L = 0
    var R = n - 1
    var r1 = 0
    var r2 = 0

    while (L < R) {
        val ans = nArray[L] + nArray[R]
        if (ans.absoluteValue < bestSum) {
            bestSum = ans.absoluteValue //bestSum을 ans로 갱신
            r1 = nArray[L]
            r2 = nArray[R]
        }

       if (ans > 0) R-- else L++ //ans가 0보다 크면 더 작아져야 하니까 R은 왼쪽으로 해서 줄이고, 작으면 반대로 L 오른쪽으로 해서 수 키우고!
    }

    bw.write("$r1 $r2")
    bw.flush()
    bw.close()
}