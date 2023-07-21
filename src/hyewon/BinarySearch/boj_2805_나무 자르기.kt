package hyewon.BinarySearch

/**
 * 분류 : 이분 탐색 / 매개 변수 탐색
 * 키 포인트 : 어떤 높이(ans)로 잘랐을 떄, 원하는 나무 길이(wanted)를 얻을 수 있는가? Yes or No
 * 정답 최대치 : 나무 수(n) * 나무 길이(m) = 1,000,000 * 1,000,000,000 => 변수형 :Long
 * memo : 나무 길이 H(index가 0~나무 최대 길이 / 원소 : 0 or 1)를 List로 만들어서...Yes 되는 지점 찾아야겠따~
 */

private const val MAX_H = 1_000_000_000L

private var N = 0
private var M = 0
private lateinit var heights: List<Int>

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().trim().split(" ").map { it.toInt() }
    N = m
    M = m
    heights = readLine().trim().split(" ").map { it.toInt() }

    var L = 0L
    var R = MAX_H
    var ans = 0L
    while (L <= R) {
        val mid = (L + R) / 2
        if (determination(mid)) {
            ans = mid
            L = mid + 1
        } else {
            R = mid - 1
        }
    }

    println(ans)
}

private fun determination(h: Long) = heights.sumOf { if (it - h > 0) it - h else 0 } >= M