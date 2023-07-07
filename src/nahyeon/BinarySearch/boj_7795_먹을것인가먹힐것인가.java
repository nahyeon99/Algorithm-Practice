package nahyeon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_7795_먹을것인가먹힐것인가 {

    static FastReader scan = new FastReader();

    static int N, M;
    static int[] A, B;

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

    static void pro() {

        // TODO: B 배열 정렬하기
        Arrays.sort(B, 1, M + 1);

        int ans = 0;

        // TODO: B에서 A[i] 보다 작은 게 몇 개 있는지 count
        for (int i = 1; i <= N; i++) {
            ans += lower_bound(B, 1, M, A[i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int tc = scan.nextInt();
        for (int i = 0; i < tc; i++) {
            input();
            pro();
        }
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
