package nahyeon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2559_수열 {

    static FastReader scan = new FastReader();

    static int N, K;
    static int A[];

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static void pro() {
        int R = 0, sum = 0, ans = -100 * N;
        for (int L = 1; L + K - 1 <= N; L++) {
            // L - 1 구간을 뺀다.
            sum -= A[L - 1]; // 해당 코드 때문에 ans = -1 초기화 시 오답 처리
            // R 을 넘길 수 있을 때까지 넘긴다.
            while (R + 1 <= L + K - 1) {
                sum += A[++R];
            }

            // 조건에 만족하면 ans 를 갱신한다.
            ans = Math.max(ans, sum);
        }

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