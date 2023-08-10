package hyewon.BruteForce

import java.io.*

/**
 * #분류 ) BruteForce
 * #포인트 ) N개중 중복이 불가능 하고 * 순서 있게 나열 하기
 * #정답의 최대치 ) N : 8, M : 8, ans : 최대 8자리 수인 배열임(IntArray)
 * #시간 복잡도 ) O(N!/(N-M)!) = 40,320
 * #공간 복잡도 ) O(m)
 * #메모
 * 1. 초기 : 모든 자리의 수가 1로 시작
 * 2. 3번과 같이 재귀 함수로 돌려주는데 used 배열로 체크해서 해당 건 빼고 진행
 */

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private lateinit var ans: IntArray
private lateinit var used: IntArray

fun main() {

    //@Input : n, m
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    ans = IntArray(m){1} //정답 초기값 : 모든 자리수가 1인 수
    used = IntArray(n+1){0} //중복 체크용 배열 : 사용한 것이면 1 아니면 0

    recFun(n, m, 0) //n : 수의 범위, m : 자리수, k : 현재 증가하고 있는 자리수

    //@Output : ans
    bw.flush()
    bw.close()

}

private fun recFun(n : Int, m : Int, k : Int){
    if(k == m){
        for(i in 0 until m) {
            bw.write("${ans[i]} ")
        }
        bw.write("\n")
    } else {
        for(num in 1..n){
            if(used[num] == 1) continue //만약 사용했으면 뒤에 생략(해당 수는 넣지 않는다)

            ans[k] = num
            used[num] = 1 //사용한 수 체크하기

            recFun(n, m, k+1) //자리수 넘겨서 1~n 돌려주기

            used[num] = 0 //한 번 돌렸으니 이제 다시 사용한 수 초기화
        }
    }
}