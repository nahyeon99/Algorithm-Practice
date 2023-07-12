package nahyeon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10816_숫자카드_2 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] NArr;

    static void input() {
        N = scan.nextInt();
        NArr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            NArr[i] = scan.nextInt();
        }
    }

    static int lower_bound(int[] A, int L, int R, int X) {
        int ans = R + 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] >= X) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    static int upper_bound(int[] A, int L, int R, int X) {
        int ans = R + 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] > X) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    static void pro() {
        // N 배열 정렬하기
        Arrays.sort(NArr, 1, N + 1);

        int M = scan.nextInt();
        for (int i = 1; i <= M; i++) {
            int M_elem = scan.nextInt();
            int upper = upper_bound(NArr, 1, N, M_elem);
            int lower = lower_bound(NArr, 1, N, M_elem);
            sb.append(upper - lower).append(' ');
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
