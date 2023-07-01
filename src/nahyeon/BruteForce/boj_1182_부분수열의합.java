package nahyeon.BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1182_부분수열의합 {

    static FastReader scan = new FastReader();

    static int N, S, ans;
    static int nums[];

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        nums = new int[N+1];

        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }
    }

    static void rec_func(int k, int value) {

        if (k == N + 1) { // 부분 수열 하나 완성
            if (S == value) ans++;
        } else {
            // k 번째 원소를 포함시킬 지 결정 후 재귀호출하기
            // Include
            rec_func(k + 1, value + nums[k]);
            // Not Include
            rec_func(k + 1, value);
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1, 0);
        // ans 는 "진 부분집합"을 다뤄야 한다.
        if (S == 0) ans--; // 공집합 제거
        System.out.println(ans);
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
