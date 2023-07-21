package hyewon.BinarySearch

import java.io.BufferedReader

fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    output.write(No2512.solve(input).toString())

    input.close()
    output.flush()
    output.close()
}

object No2512 {
    fun solve(input: BufferedReader): Int {
        val numberOfCities = input.readLine().toInt()
        val cities = input.readLine().split(" ").map { it.toInt() }
        val budget = input.readLine().toInt()

        var start = 0
        var end = cities.maxOrNull()!!
        var result = 0

        while (start <= end) {
            val mid = (start + end) / 2
            var sum = 0

            for (city in cities) {
                sum += if (city > mid) mid else city
            }

            if (sum <= budget) {
                start = mid + 1
                result = mid
            } else {
                end = mid - 1
            }
        }

        return result
    }
}
