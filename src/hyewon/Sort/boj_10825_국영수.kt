package hyewon.Sort

import java.io.*

private data class Student(
    val name: String,
    val kor: Int,
    val eng: Int,
    val math: Int
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val list = List(n) {
        val (a, b, c, d) = br.readLine().split(" ")
        Student(a, b.toInt(), c.toInt(), d.toInt())
    }

    val result = list.sortedWith(
        compareBy(
            {-it.kor},
            {it.eng},
            {-it.math},
            {it.name}
        )
    )

    result.forEach {
        bw.write("${it.name}\n")
    }
    bw.flush()
    bw.close()
}