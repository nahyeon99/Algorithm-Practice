package hyewon.BruteForce

import java.io.*

/**
 * #분류 ) BruteForce
 * #포인트 ) N개중 중복이 불가능 하고 * 순서 있게 나열 하기
 * #정답의 최대치 ) N : 11, A_i : 100, ans : -1_000_000_000 ~ 1_000_000_000
 * #시간 복잡도 ) O(N!/(N-M)!) = 3_628_800
 * #공간 복잡도 ) O(m)
 * #메모
 * 1.
 */

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private var min = 0
private var max = 0

fun main(){
    val n = br.readLine().toInt() //수의 개수
    val nums = br.readLine().split(" ").map { it.toInt() }
    val operators = br.readLine().split(" ").map { it.toInt() }

    recFun(n, 0)

    bw.flush()
    bw.close()
}

private fun recFun(n : Int, k : Int) {
    //종료 조건 : 만약 연산자 선택이 다 끝났으면 종료

}
