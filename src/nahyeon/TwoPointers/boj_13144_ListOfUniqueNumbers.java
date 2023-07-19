package nahyeon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13144_ListOfUniqueNumbers {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, A[], count[];

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        count = new int[100000 + 1]; // N <= 100,000
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    /**
     * 시간 초과 해결 O(N)
     * 1. 왼쪽 시작 L 의 이동 횟수 N 번
     * 2. 오른쪽 끝을 R을 이전의 R 부터 시작해서 이동
     * 3. L, R 이 각자 최대 N 번 이동하므로, O(N)
     */
    static void pro() {
        long ans = 0;

        for (int L = 1, R = 0; L <= N; L++) {
            // R 을 옮길 수 있는 만큼 옮긴다.
            while (R + 1 <= N && count[A[R + 1]] == 0) {
                R++;
                count[A[R]]++;
            }
            // R 이 넘겨진 카운트만큼 정답을 갱신한다.
            ans += (R - L + 1);

            // L 을 넘기면서 A[L] 의 개수를 감소시킨다.
            count[A[L]]--;
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
