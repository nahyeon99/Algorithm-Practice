package hyewon.BinarySearch

import java.io.*


//nArray를 정렬하고 "찾으려는 수 = 합-원소" 를 찾는 것이 포인트
//질문 있음

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val nArray = br.readLine().split(" ").map { it.toInt() }.sorted().toIntArray()
    val targetSum = br.readLine().toInt()

    var ans = 0

    nArray.forEach{
        ans += search(nArray, targetSum - it, nArray.lastIndex)
    }

    bw.write("${ans/2}") // 이렇게 함..님은 어케 함?
    bw.flush()
    bw.close()

}

private fun search(arr : IntArray, target : Int, end : Int) : Int{
    var L = 0
    var R = end

    while (L <= R) {
        val M = (L + R) / 2

        if(arr[M] == target) return 1
        else if(arr[M] > target)  R = M - 1;
        else L = M + 1
    }
    return 0;
}

/* 이거 잘 모르겠음. 같이 고민해 보자...ㅎ
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val nArray = br.readLine().split(" ").map{it.toInt()}
    val targetSum = br.readLine().toInt()

    val counts = IntArray(1_000_001)

    var ans = 0
    nArray.forEach {
        val target = targetSum - it
        if (target <= 0 || target > 1_000_000) {
            return@forEach
        }

        ans += counts[target]
        counts[it]++
    }

    bw.write("$ans")
    bw.flush()
    bw.close()
}
 */