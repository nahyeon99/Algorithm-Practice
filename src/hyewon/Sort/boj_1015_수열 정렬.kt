package hyewon.Sort

import java.io.*

private data class ListB(val num : Int, val id : Int)

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))



    fun inputB() {
        val n = br.readLine().toInt()
        var listB = List(n) { List(2) { } }
        for (i in 1..n){
        }

    }

    inputB()



    bw.flush()
    bw.close()

}