package hyewon.BruteForce



fun main() {
    lateinit var arr: Array<Int>

    var n = 0
    var m = 0
    val sb = StringBuilder()

    val nm = readLine()!!.split(" ")
    m = nm[1].toInt()
    n = nm[0].toInt()

    arr = Array(n + 1) { i -> i }

    dfs(1, 0, "")
    print(sb.toString())


    fun dfs(idx: Int, len: Int, str: String) {
        if (len == hyewon.BruteForce.m) {
            sb.append(str).append("\n")
            return
        }

        for (i in 1..hyewon.BruteForce.n) {
            if (len == 0)
                dfs(i, 1, hyewon.BruteForce.arr[i].toString())
            else
                dfs(i, len + 1, "$str ${hyewon.BruteForce.arr[i]}")
        }
    }
}
