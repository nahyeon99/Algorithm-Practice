package nahyeon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2805_나무자르기 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] a;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        a = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i] = scan.nextInt();
        }
    }

    static boolean determination(int H) {
        // 나무를 H 높으로 잡았을 때,
        // 자른 나무 길이의 합이 M 이상 이면 true 를, 아니면 false 를 return 한다.
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            if (a[i] > H) {
                sum += (a[i] - H);
            }
        }
        return sum >= M;
    }

    static void pro() {
        Arrays.sort(a, 1, N + 1);

        long L = 0, R = 2000000000, ans = 0;
        while (L <= R) {
            int mid = (int)(L + R) / 2;

            if (determination(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
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
            while (st == null || !st.hasMoreElements()) {
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
