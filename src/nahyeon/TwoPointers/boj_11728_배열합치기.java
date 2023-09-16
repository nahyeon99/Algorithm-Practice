package nahyeon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11728_배열합치기 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int A[], B[];

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        B = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        for (int i = 1; i <= M; i++) {
            B[i] = scan.nextInt();
        }
    }


    static void pro() {

        int L = 1, R = 1;
        // 배열 A,B 둘 다 값이 남아있는 경우
        while (L <= N && R <= M) {
            if (A[L] <= B[R])
                sb.append(A[L++]).append(' ');
            else
                sb.append(B[R++]).append(' ');
        }

        // 배열 A 만 값이 남아있는 경우
        while (L <= N)
            sb.append(A[L++]).append(' ');

        // 배열 B 만 값이 남아있는 경우
        while (R <= M)
            sb.append(B[L++]).append(' ');

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
