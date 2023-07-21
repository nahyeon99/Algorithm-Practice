package hyewon.BruteForce


private fun dfs(idx: Int, sum: Int, n: Int, s: Int){
    var answer=0

    lateinit var arr: List<Int>

    if(idx==n) return
    if(sum+arr[idx]==s) answer++

    dfs(idx+1,sum,n,s)
    dfs(idx+1,sum+arr[idx],n,s)
}

fun main() = with(System.out.bufferedWriter()){
    var answer=0

    lateinit var arr: List<Int>
    val br = System.`in`.bufferedReader()



    val (n,s) = br.readLine().split(' ').map{it.toInt()}
    arr = br.readLine().split(' ').map { it.toInt() }


    dfs(0,0,n,s)

    write("$answer")
    close()
}