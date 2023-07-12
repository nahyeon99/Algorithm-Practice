package hyewon.BinarySearch

import java.*

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))

lateinit var NM : List<String>
lateinit var A : List<String>
lateinit var B : List<String>

fun main(){
    repeat(br.readLine().toInt()) {

        input()
        search()
    }
}


private fun input(){
    NM = br.readLine().split(' ')

    A = br.readLine().split(' ')
    B = br.readLine().split(' ')

}

private fun search(){
    B.sorted()




}

private fun serachFood(A : List<String>,T : Int, L : Int, R : Int) {
    var result = L - 1

    while ( L <= R) {
        var M = (L + R) / 2
        if(A[M] < T) {
            result = M
            L = M + 1
        }else{
            r
        }
    }
}

static int lower_bound(int[] A, int L, int R, int X) {
    // A[L...R] 에서 X 미만의 수 중 제일 오른쪽 인덱스를 반환한다.
    // 그런 값이 없다면 L - 1을 리턴한다.

    int result = L - 1; // 탐색한 값의 인덱스
    while (L <= R) {
        int M = (L + R) / 2;
        if (A[M] < X) {
            result = M;
            L = M + 1;
        } else {
            R = M - 1;
        }
    }
    return result;
}