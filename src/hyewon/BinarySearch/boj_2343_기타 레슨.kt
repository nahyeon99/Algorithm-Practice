package hyewon.BinarySearch

import java.io.*
import java.util.*

/***
 * 답 최소 값 : 강의 녹화 시간 중 가장 긴 거/ 답 최대 값 : 모든 강의의 합(한 블루 레이에 다 떄려 넣기)
 *
 */


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val arr = IntArray(N){0}
    st = StringTokenizer(br.readLine())
    repeat(N){
        arr[it] = st.nextToken().toInt()
    }
    var start = arr.max()
    var end = arr.sum()

    while(start < end){
        var count = 1
        val mid = (start+end)/2
        var sum = 0
        for(num in arr){
            if(sum + num <= mid){ //sum과 num의 중간 값을 갖구.....mid계산하면서 Yes or No 해보면 됨~
                sum+=num
            } else {
                sum = num
                count++
            }
        }
        if(count <= M){
            end = mid
        }else{
            start = mid+1
        }
    }
    bw.write("$start")
    bw.flush()
    bw.close()
}