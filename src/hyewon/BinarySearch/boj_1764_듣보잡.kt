package hyewon.BinarySearch

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val neverHeard = HashMap<String, Boolean>()
    val neverSeen = HashMap<String, Boolean>()
    val neverHS = mutableListOf<String>()


    val n = br.readLine().split(" ")

    repeat(n[0].toInt() + n[1].toInt()) { i ->
        val person = br.readLine()

        if(i < n[0].toInt()) {
            neverHeard.put(person, true)
        }else{
            neverSeen.put(person, true)
        }

    }

    if(neverHeard.size < neverSeen.size) {
        neverSeen.forEach {
            if(neverHeard.get(it.key) == true) neverHS.add((it.key))
        }
    }else{
        neverHeard.forEach{
            if(neverSeen.get(it.key) == true) neverHS.add((it.key))
        }
    }

    bw.write("${neverHS.size}\n")

    neverHS.sort()
    neverHS.forEach {
        bw.write("$it\n")
    }

    bw.flush()
    bw.close()

}