package nahyeon.TwoPointers;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2230_수고르기 {

    static FastReader scan = new FastReader();

    static int N, M;
    static int[] A;


    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }


    static void pro() {
        // 가장 작은 차이를 출력하기 위해서, A 배열을 정렬한다.
        Arrays.sort(A, 1, N + 1);

        int R = 1, ans = Integer.MAX_VALUE;
        for (int L = 1; L <= N; L++) {
            // R 을 넘길 수 있을 때 까지 넘긴다.
            while (R + 1 <= N && A[R] - A[L] < M)
                R++;

            if (A[R] - A[L] >= M)
                ans = Math.min(ans, A[R] - A[L]);
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
