package nahyeon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2470_두용액 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, A[];

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(A, 1, N + 1);

        int diff = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0, L = 1, R = N;
        while (L < R) { // L == R 일 때, 용액이 하나이므로 탈출한다.
            int sum = A[L] + A[R];
            if (Math.abs(sum) < diff) {
                diff = Math.min(diff, Math.abs(sum));
                v1 = A[L];
                v2 = A[R];
            }

            if (sum < 0) {
                L++;
            } else {
                R--;
            }
        }
        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);
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
