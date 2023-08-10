package hyewon.BruteForce

import java.io.*

/**
 * #분류 ) BruteForce
 * #포인트 ) N개중 중복이 가능 하고 * 고르기
 * #정답의 최대치 ) N : 8, M : 8, ans : 최대 8자리 수인 배열임(IntArray)
 * #시간 복잡도 ) O(N^M)
 * #공간 복잡도 ) O(m)
 * #메모
 * 1. 초기 : 모든 자리의 수가 1로 시작
 * 2. 3번과 같이 재귀 함수로 돌려주는데 사용한 수보다 작은 값이면 안 된다.
 */

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private var usedNum = 1
private lateinit var ans: IntArray

fun main() {

    //@Input : n, m
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    ans = IntArray(m+1){1} //정답 초기값 : 모든 자리수가 1인 수

    recFun(n, m, 1) //n : 수의 범위, m : 자리수, k : 현재 증가하고 있는 자리수

    //@Output : ans
    bw.flush()
    bw.close()

}

private fun recFun(n : Int, m : Int, k : Int){
    if(k == m+1){
        for(i in 1..m) {
            bw.write("${ans[i]} ")
        }
        bw.write("\n")
    } else {
        usedNum = ans[k-1]

        for(num in usedNum..n){
            ans[k] = num
            recFun(n, m, k+1) //자리수 넘겨서 1~n 돌려주기
        }

    }
}