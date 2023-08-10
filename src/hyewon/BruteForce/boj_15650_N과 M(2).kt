package hyewon.BruteForce

import java.io.*

/**
 * #분류 ) BruteForce
 * #포인트 ) N개중 중복이 불가능 하고 * 고르기
 * #정답의 최대치 ) N : 8, M : 8, ans : 최대 8자리 수인 배열임(IntArray)
 * #시간 복잡도 ) O(N!/M!(N-M)!)
 * #공간 복잡도 ) O(m)
 * #메모
 *
 *
 */

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private lateinit var used: IntArray
private lateinit var ans: IntArray


fun main() {

    //@Input : n, m
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    ans = IntArray(m+1){1} //정답 초기값 : 모든 자리수가 1인 수
    used = IntArray(n+1){0} //중복 체크용 배열 : 사용한 것이면 1 아니면 0

    recFun(n, m, 1) //n : 수의 범위, m : 자리수, k : 현재 증가하고 있는 자리수

    bw.flush()
    bw.close()
}

private fun recFun(n : Int, m : Int, k : Int){
    //종료 조건
    if(k == m+1 ){
        for(i in 1 .. m) bw.write("${ans[i]} ")
        bw.write("\n")
    } else {
        //고르기(오름차순) : 이전의 수보다 작은지 체크
        val startNum = ans[k-1]

        for(num in startNum..n){
            //중복 불가능 : 사용한 수인지 체크
            if(used[num]==1) continue

            ans[k] = num
            used[num] = 1 //중복 불가능 : 사용한 수면 1로 바꾸기

            recFun(n, m, k+1)

            used[num] = 0 //중복 불가능 : 사용한 수 끝나면 0으로 바꾸기
        }
    }
}