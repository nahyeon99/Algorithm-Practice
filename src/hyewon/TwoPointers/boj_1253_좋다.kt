package hyewon.TwoPointers

import java.io.*

/**
 * 분류 : 두 포인터
 * memo : 오른차순 정렬하구,,,타겟 수 하나 찝고,,,,최소(L), 최대(R)의 합이 타겟 수보다 작으면 L++, 반대의 경우 R++
 */

private var N = 0
private lateinit var A: List<Int>

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    N = br.readLine().toInt()
    A = br.readLine().split(" ").map { it.toInt() }.sorted()

    var ans = 0
    for (i in 0 until N) {
        if (isGood(i)) ans++
    }

    bw.write("$ans")
    bw.flush()
    bw.close()
}

private fun isGood(targetIndex: Int): Boolean {
    val target = A[targetIndex]
    var L = 0
    var R = N - 1
    while (L < R) {
        if (L == targetIndex) L++
        else if (R == targetIndex) R--
        else {
            val sum = A[L] + A[R]
            if (sum == target) return true
            else if (sum < target) L++
            else R--
        }
    }

    return false
}