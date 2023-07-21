package hyewon.TwoPointers

/**
 * 주저리
 * L이 1일 때, R이 5에서 멈춘당. => L을 2로 땡겼을 때, R을 굳이 2부터 다시 시작할 필요가 있을까? => X => 5부터 시작하면 된다.
 */
fun main() = with(System.`in`.bufferedReader()) {
    val (N, S) = readLine().split(" ").map { it.toInt() }
    val A = ("0 " + readLine()).split(" ").map { it.toInt() }

    var R = 0
    var sum = 0
    var ans = N + 1
    for (L in 1..N) {
        // for문에 의해 L이 1증가했으므로, L - 1을 구간에서 제외
        sum -= A[L - 1]

        // R을 옮길 수 있을 때 까지 옮긴다.
        // R의 오른쪽 칸(R + 1)이 구간을 벗어나면 안되고, sum이 S이상이 될 때 까지
        while (R + 1 <= N && sum < S) {
            R++ // R을 옮겨주고
            sum += A[R] // sum에 새로 들어온 A[R]을 더함
        }

        // [L..R]의 합 즉, sum이 조건을 만족하면 정답 갱신
        if (sum >= S) ans = minOf(ans, R - L + 1)
    }

    if (ans == N + 1) ans = 0

    println(ans)
}