package hyewon.Sort

import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val extensionList = mutableMapOf<String, Int>()

    repeat(br.readLine().toInt()) {
        val extension = br.readLine().split(".")[1]

        if(extensionList.containsKey(extension))
            extensionList[extension] = extensionList[extension]!! + 1
        else
            extensionList[extension] = 1
    }

    extensionList.toSortedMap().forEach(){
        bw.write("${it.key} ${it.value}\n")
    }

    bw.flush()
    bw.close()
}