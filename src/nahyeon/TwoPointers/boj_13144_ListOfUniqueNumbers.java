package nahyeon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13144_ListOfUniqueNumbers {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, A[];

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    /**
     * 시간 초과 풀이 O(N^3)
     * 1. 왼쪽 시작 L 결정 -> O(N)
     * 2. 오른쪽 끝 R 을 L 부터 시작해서 이동 -> O(N)
     * 3. R 을 이동해서 추가된 원소가 [L, R-1] 안에 있는지 확인 -> O(N)
     */
    static void pro() {
        long ans = 0;

        for (int L = 1; L <= N; L++) {

            for (int R = L; R <= N; R++) {
                int checkValue = A[R];
                boolean pass = true;

                for (int i = L; i <= R - 1; i++) {
                    if (A[i] == checkValue) {
                        pass = false;
                        break;
                    }
                }
                if (pass)
                    ans++;
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
