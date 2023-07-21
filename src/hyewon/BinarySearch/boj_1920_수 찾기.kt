package hyewon.BinarySearch

import java.io.*


private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun main() {


    val n = br.readLine().toInt()
    val nArray = br.readLine().split(" ").map { it.toInt() }.toIntArray().sortedArray()
    val m = br.readLine().toInt()
    val mArray = br.readLine().split(" ").map { it.toInt() }

    for(i in mArray){
        bw.write("${search(nArray, i, nArray.lastIndex)}\n")
    }

    bw.flush()
    bw.close()
}

private fun search(arr : IntArray, target : Int, end : Int) : Int{
    var L = 0
    var R = end

    while (L <= R) {
        val M = (L + R) / 2
        if(arr[M] == target) return 1
        else if(arr[M] > target) {
            R = M - 1;
        } else {
            L = M + 1
        }
    }
    return 0;
}

/*
 //이게 더 효율이 좋음!
fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val nSet = br.readLine().split(" ").map { it.toInt() }.toHashSet() //Set형으로 해서 원소 안 겹치게!

    val m = br.readLine().toInt()
    val mArray = br.readLine().split(" ").map { it.toInt() }

    for(i in mArray){
        if(nSet.contains(i)) bw.write("1\n") //Set은 contains()로 찾는다.
        else bw.write("0\n")
    }

    bw.flush()
    bw.close()
}
*/