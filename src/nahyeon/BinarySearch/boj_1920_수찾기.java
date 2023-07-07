package nahyeon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1920_수찾기 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        M = scan.nextInt();
        B = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            B[i] = scan.nextInt();
        }
    }

    static int search(int A[], int L, int R, int X) {
        // A[L...R]에 X의 존재 여부를 찾기 위해 탐색한다.
        // 존재하면 1, 존재하지 않으면 0을 반환한다.

        while (L <= R) {
            int mid = (L + R) / 2;

            if (A[mid] == X) return 1;
            else if (A[mid] > X) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return 0;
    }

    static void pro() {

        // 1. A 배열 정렬
        Arrays.sort(A, 1, N + 1);

        // 2. B 배열 원소를 택한다. A 배열에 존재 여부를 이분 탐색을 활용하여 탐색한다.
        for (int b_idx = 1; b_idx <= M; b_idx++) {
            // B[b_idx]를 정렬된 A 에서 탐색
            int result = search(A, 1, N, B[b_idx]);

            // 3. 존재 여부를 결과값에 저장한다.
            sb.append(result).append('\n');
        }
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
