package hyewon.BruteForce

val br = System.`in`.bufferedReader()


var answer=0

fun dfs(idx: Int, sum: Int, n: Int, s: Int){
    lateinit var arr: List<Int>

    if(idx==n) return
    if(sum+arr[idx]==s) answer++

    dfs(idx+1,sum,n,s)
    dfs(idx+1,sum+arr[idx],n,s)
}

fun main() = with(System.out.bufferedWriter()){
    lateinit var arr: List<Int>
    //input
    val (n,s) = br.readLine().split(' ').map{it.toInt()}
    arr = br.readLine().split(' ').map { it.toInt() }

    //solve
    dfs(0,0,n,s)
    //output
    write("$answer")
    close()
}