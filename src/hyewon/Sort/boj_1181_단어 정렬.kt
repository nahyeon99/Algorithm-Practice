package hyewon.Sort

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val dic = hashSetOf<String>()

    val n = br.readLine().toInt()

    for(i in 1..n) {
        dic.add(br.readLine())
    }

    val result = dic.toList().sortedWith(
        compareBy(
            { it.length },
            { it },
        )
    )

    result.forEach{
        bw.write("$it\n")
    }

    bw.flush()
    bw.close()
}