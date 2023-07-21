package hyewon.BruteForce

import java.lang.Math.abs
import java.util.*




fun main(args : Array<String>) = with(Scanner(System.`in`)){
    var n = 0
    val sum = 0


    n = nextInt()
    dfs(0)
    println(sum)
}

private fun dfs(x : Int){
    var sum = 0
    var col = Array(15){0}

    if(x == n) sum++
    else{
        for(i in 0 until n){
            col[x] = i
            if(check(x))
                dfs(x+1)
        }
    }
}

private fun check(level : Int) : Boolean{
    var col = Array(15){0}

    for(i in 0 until level)
        if(col[i] == col[level] || abs(col[level] - col[i]) == level - i) return false
    return true
}