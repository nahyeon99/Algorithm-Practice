package hyewon.Sort

import java.io.*


//같은 색끼리 좌표를 묶어 주고, 오름차순으로 정렬하는 게 포인트!
fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val dots = Array(n+1){ mutableListOf<Int>()}
    //n아니고 n+1이다!! 주의!! index 고려해서 하나 더 늘려 주기
    repeat(n) {
        val (coord, color) = br.readLine().split(" ").map { it.toInt() }
        dots[color].add(coord)
    }

    var ans = 0

    for (dot in dots.filter { it.isNotEmpty() }) {
        dot.sort() //색깔 별로 오름차순 정렬
        for (i in dot.indices) { //dot.indices = 0..lastIndex => dot의 index를 순회
            ans += minOf(
                //minOf = 가장 가까운 점 구하기
                if (i == 0) Int.MAX_VALUE else dot[i] - dot[i - 1] , // 왼쪽에서 가장 가까운 점 반환
                if (i == dot.lastIndex) Int.MAX_VALUE else dot[i + 1] - dot[i] //오른쪽에서 가장 가까운 점 반환
            )
        }
    }

    bw.write("$ans")

    bw.flush()
    bw.close()
}
