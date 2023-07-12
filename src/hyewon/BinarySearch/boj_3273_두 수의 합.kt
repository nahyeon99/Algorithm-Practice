package hyewon.BinarySearch

private var n  = 0
private lateinit var arr : IntArray
private var x  = 0
private lateinit var subs : BooleanArray

fun main() {
    val br = System.`in`.bufferedReader()
    n = br.readLine().toInt()
    arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    x = br.readLine().toInt()
    subs = BooleanArray(x+1){false}

    var result = 0
    for(i in 0 until n){
        if(arr[i]>=x) continue
        if(subs[x-arr[i]])
            result += 1
        subs[arr[i]] = true
    }
    println(result)
}

