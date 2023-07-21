package hyewon.BruteForce

lateinit var check: BooleanArray
lateinit var ans: IntArray
val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {



    val (n, m) = readLine().split(" ").map { it.toInt() }
    check = BooleanArray(n + 1)
    ans = IntArray(m)
    go(0, 1, n, m)
    println(sb)
}

private fun go(idx: Int, start : Int, n: Int, m: Int) {
    if (idx == m) {
        ans.forEach { sb.append(it).append(' ') }
        sb.append("\n")
        return
    }

    for (i in start..n) {
        if (check[i]) continue
        check[i] = true
        ans[idx] = i
        go(idx + 1, i + 1, n, m)
        check[i] = false
    }
}

