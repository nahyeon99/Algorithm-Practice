package hyewon.BruteForce

import java.io.*

/**
 * #분류 ) BruteForce
 * #포인트 ) N개중 중복이 가능 하고 * 순서 있게 나열 하기
 * #정답의 최대치 ) N : 7, M : 7, ans : 최대 7자리 수인 배열임(IntArray)
 * #시간 복잡도 ) O(n^m)
 * #공간 복잡도 ) O(m)
 * #메모
 * 1. 초기 : 모든 자리의 수가 1로 시작
 * 2. 0번째 자리수부터 1~n까지 돌리는데
 * 3. 재귀 함수 넣어서 다음 자리도 1~n까지 돌려 주기.
 * 4. 끝자리 수에 값넣을 때까지 출력 안 함함 */


private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private lateinit var ans: IntArray

fun main() {

    //@Input : n, m
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    ans = IntArray(m){1} //정답 초기값 : 모든 자리수가 1인 수

    recFun(n, m, 0) //n : 수의 범위, m : 자리수, k : 현재 증가하고 있는 자리수

    //@Output : ans
    bw.flush()
    bw.close()
}

private fun recFun(n: Int, m: Int, k: Int){
    if(k==m){ //끝자리 수까지 수를 정해주어서 index넘어 섰으면
        for(i in 0 until m){ // ans write
            bw.write("${ans[i]} ")
        }
        bw.write("\n")
    } else {
        for(num in 1..n){ //첫번째 자리 수(index 0)부터 차근차근 ++ 해주기
            ans[k] = num
            recFun(n, m, k+1) //다음 자리수 수 같은 방법으로 1~n돌리면서 값을 넣어주기 위해서 k+1 해서 재귀 함수
        }
    }

}