package nahyeon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_15970_화살표그리기 {

    static FastReader scan = new FastReader();

    static int N;
    static ArrayList<Integer>[] a;

    static void input() {

        N = scan.nextInt();
        a = new ArrayList[N + 1];

        for (int dot = 1; dot <= N; dot++) {
            a[dot] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= N; i++) {
            int coord, color;
            coord = scan.nextInt();
            color = scan.nextInt();

            a[color].add(coord);
        }
    }

    static int toLeft(int color, int idx) {
        if (idx < 1) return Integer.MAX_VALUE;
        return a[color].get(idx) - a[color].get(idx - 1);
    }

    static int toRight(int color, int idx) {
        if (idx + 1 >= a[color].size()) return Integer.MAX_VALUE;
        return a[color].get(idx + 1) - a[color].get(idx);
    }

    static void pro() {
        // TODO: 색깔별로 정렬하기
        for (int color = 1; color <= N; color++) {
            Collections.sort(a[color]);
        }

        int ans = 0;
        // TODO: 점마다 가장 가까운 점 찾기
        for (int color = 1; color <= N; color++) {
            int arrSizeByColor = a[color].size();
            for (int i = 0; i < arrSizeByColor; i++) {
                int left = toLeft(color, i);
                int right = toRight(color, i);

                ans += Math.min(left, right);
            }
        }

        // TODO: 합 출력하기
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
