package nahyeon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_3273_두수의합 {

    static FastReader scan = new FastReader();

    static int N, X, ans;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        X = scan.nextInt();
    }

    static boolean search(int[] A, int L, int R, int X) {
        // A[L...R] 에서 X의 존재 여부를 이진탐색한다.
        // 존재 시 true 를, 존재하지 않으면 false 를 반환한다.

        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] == X) return true;
            else if (A[mid] < X) L = mid + 1;
            else R = mid - 1;
        }

        return false;
    }

    static void pro() {
        // A 배열 오름차순 정렬한다.
        Arrays.sort(A, 1, N + 1);

        // A[a_idx+1...N] 에서 (X - A[a_idx]) 의 존재 여부를 이진 탐색한다.
        // 존재 시, ans 를 갱신한다.
        for (int a_idx = 1; a_idx <= N; a_idx++) {
            // A[a_idx]
            int search_value = X - A[a_idx];
            boolean res = search(A, a_idx + 1, N, search_value);

            if (res) ans++;
        }

        // ans 출력한다.
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
