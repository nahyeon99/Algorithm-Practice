package hyewon.BruteForce

import java.util.*
import kotlin.math.*

fun main() = with(Scanner(System.`in`)){
    var arr = IntArray(100){0}
    var sign = IntArray(4){0}
    var n = 0
    var max = -100000000
    var min = 100000000

    // 수의 개수 입력
    n = nextInt()

    // 수열 입력
    for (i in 0 until n) arr[i] = nextInt()

    // 부호 수 입력
    for (i in sign.indices) sign[i] = nextInt()

    // dfs
    fun find(a : Int, x : Int){
        // 탐색 완료
        if(a == n){
            max = max(max,x)
            min = min(min,x)
        }

        for(i in sign.indices){
            if(sign[i] != 0){
                sign[i]--
                when(i){
                    0 -> find(a+1,x+arr[a])
                    1 -> find(a+1,x-arr[a])
                    2 -> find(a+1,x*arr[a])
                    3 -> find(a+1,x/arr[a])
                }
                sign[i]++
            }
        }
    }

    find(1,arr[0])

    println(max)
    println(min)

}