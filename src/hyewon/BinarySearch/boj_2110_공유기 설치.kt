package hyewon.BinarySearch

import java.io.*
import java.util.*


/**
 *  last 설치 장소 + 최대거리 띄운 후 설치, 로 공유기 c개를 설치하는 것
 * */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val line = StringTokenizer(br.readLine())
    val k = line.nextToken().toInt()
    val num = line.nextToken().toInt()

    val arr = Array(k){0}
    for(i in 0 until k) {
        arr[i] = br.readLine().toInt()
    }

    arr.sort()

    var lo = 1 //최소 길이
    var hi = arr[k-1] - arr[0] // 최대 길이(마지막 집 - 첫 집)
    var ans = 0

    while(lo<=hi) {
        val mid = (lo+hi)/2 //공유기 거리 기준
        var cnt = 1 //공유기 개수
        var tmp = arr[0] //첫 위치에 설치

        for(i in 0 until k) {
            val dis = arr[i] - tmp
            if(dis>=mid) {  //일정 거리 이상 돼야지 설치
                cnt++
                tmp = arr[i]
            }
        }

        if(cnt<num) { //공유기가 num 넘지 않으니 설치 ㄱㄱ
            hi = mid - 1
        } else {
            lo = mid + 1
            ans = mid
        }
    }

    bw.write("$ans")
    bw.flush()
    bw.close()
    br.close()
}