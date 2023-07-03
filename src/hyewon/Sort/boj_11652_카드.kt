package hyewon.Sort

import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    val list = List(n){
        val a =  br.readLine().toLong()
        a
    }

    fun check() {

        val result = list.sortedDescending()

        var curCnt = 1
        var maxCnt = 1
        var modeNum = result[0]


        for(i in 1 until n){
            if(result[i-1] == result[i])
                curCnt += 1
            else
                curCnt = 1

            if(curCnt >= maxCnt){
                maxCnt = curCnt
                modeNum = result[i]
            }
        }

        bw.write(modeNum.toString())
    }

    check()

    bw.flush()
    bw.close()
}