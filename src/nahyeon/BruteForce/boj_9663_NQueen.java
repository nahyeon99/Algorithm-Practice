package nahyeon.BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class boj_9663_NQueen {

    static FastReader scan = new FastReader();

    static int N, ans;
    static int[] col; // col[i] : i번 행의 퀸은 col[i]번 열에 놓았다는 기록

    static void input() {
        N = scan.nextInt();
        col = new int[N+1];
    }

    static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;
        if (r1 - c1 == r2 - c2) return true; // 왼쪽 대각선이 같은 경우
        if (r1 + c1 == r2 + c2) return true; // 오른쪽 대각선이 같은 경우
        return false;
    }

    /**
     * 해당 풀이 문제점
     * 더 작은 범위에서 이미 공격이 가능하다면, 더 큰 범위 내에서의 공격 가능성을 체크하는 것이 의미가 없다.
     * 즉, (1,1)에 퀸을 놓았다면, 2번째 행에서는 가능한 위치에만 퀸을 놓는다.
     * 그러므로 애초에 1,2 열을 제외한 3,4,5 열에만 퀸을 놓음으로써 불가능한 1,2 열은 완전탐색을 시도조차 하지 않게 한다.
     */
    static boolean validity_check() {
        for (int i = 1; i<=N; i++) {
            // (i, col[i])
            for (int j = 1; j < i; j++) {
                // (j, col[j])
                if (attackable(i, col[i], j, col[j])) { // 공격 가능 시
                    return false;
                }
            }
        }
        return true;
    }

    // row 번 ~ N 번 행에 대해서 가능한 퀸을 놓는 경우의 수 구하기

    static void rec_func(int row) {
        if (row == N + 1) { // 각 행마다 하나씩 잘 놓았다.
            if (validity_check()) { // 서로 공격하는 퀸들이 없는 경우
                ans++;
            }
        } else {
            for (int cand = 1; cand <= N; cand++) {
                col[row] = cand;
                rec_func(row + 1);
                col[row] = 0;
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
