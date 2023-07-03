package nahyeon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11652_카드 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static long[] a;

    static void input() {
        N = scan.nextInt();
        a = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i] = scan.nextLong();
        }
    }

    static void pro() {

        // Sort 정렬하기
        Arrays.sort(a, 1, N+1);

        // mode: 최빈값, modeCnt: 최빈값의 등장 횟수, curCnt: 현재 값(a[1])의 등장 횟수
        long mode = a[1];
        int modeCnt = 1, curCnt = 1;

        /**
         * 2번 원소부터 차례대로 보면서, 같은 숫자가 이어서 나오고 이는지, 새로운 숫자가 나왔는 지를 판단하여
         * curCnt와 modeCnt를 갱신한다.
         */
        for (int i = 2; i <=N; i++) {
            if (a[i] == a[i-1]) {
                curCnt++;
            } else {
                curCnt = 1;
            }
            if (modeCnt < curCnt) {
                mode = a[i];
                modeCnt = curCnt;
            }
        }

        System.out.println(mode);
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
