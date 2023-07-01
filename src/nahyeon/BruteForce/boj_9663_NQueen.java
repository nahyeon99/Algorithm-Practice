package nahyeon.BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class boj_9663_NQueen {

    static FastReader scan = new FastReader();

    static int N, ans;
    static int cols[]; // (i, cols[i])

    static void input() {
        N = scan.nextInt();
        cols = new int[N + 1];
    }

    static boolean attackable(int r1, int c1, int r2, int c2) {
        if (r1 == r2 || c1 == c2) return true;
        if (r1 - c1 == r2 - c2) return true;
        if (r1 + c1 == r2 + c2) return true;
        return false;
    }

    // row 번 ~ N 번 행에 대해서 가능한 퀸을 놓는 경우의 수 구하기

    static void rec_func(int row) {
        if (row == N + 1) {
            ans++;
        } else {
            for (int cand = 1; cand <= N; cand++) {
                boolean possible = true;
                // validity check(row, cand)
                for (int i = 1; i <= row - 1; i++) {
                    // (i, cols[i])
                    if (attackable(row, cand, i, cols[i])) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    cols[row] = cand;
                    rec_func(row + 1);
                    cols[row] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
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
