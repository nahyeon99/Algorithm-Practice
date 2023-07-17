package nahyeon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1806_부분합 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, S;
    static int A[];

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static void pro() {
        int R = 0, sum = 0, ans = N + 1;
        for (int L = 1; L <= N; L++) {
            // L - 1 부분 빼기
            sum -= A[L-1];
            // R 을 조건에 만족할 때 까지 넘기기
            while (R + 1 < N && sum < S) {
                sum += A[++R];
            }
            // 조건이 만족하면 정답을 갱신한다.
            if (sum > S)
                ans = Math.min(ans, R - L + 1);
        }
        // 해당되는 조건이 없다면 0으로 갱신한다.
        if (ans == N + 1)
            ans = 0;
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
