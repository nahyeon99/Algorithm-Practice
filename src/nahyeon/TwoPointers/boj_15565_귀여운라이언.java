package nahyeon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15565_귀여운라이언 {
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
        int R = 0, cnt = 0, ans = -1;
        for (int L = 1; L <= N; L++) {
            while (R + 1 <= N && cnt < K) {
                R++;
                if (A[R] == 1)
                    cnt++;
            }

            if (cnt == K) {
                if (ans == -1)
                    ans = R - L + 1;
                else
                    ans = Math.min(ans, R - L + 1);
            }
            if (A[L] == 1)
                cnt--;
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
