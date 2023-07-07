package nahyeon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2470_두용액 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static int lower_bound(int[] A, int L, int R, int X) {
        // A[L...R] 중 X 이상의 수 중 제일 왼쪽 인덱스를 return 하는 함수
        // 그런 게 없다면 R + 1 을 return 한다.
        int result = R + 1;
        while (L <= R) {
            int M = (L + R) / 2;
            if (A[M] >= X) {
                result = M;
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        return result;
    }

    static void pro() {
        // TODO: A 배열 정렬하기
        Arrays.sort(A, 1, N + 1);

        int bestSum = Integer.MAX_VALUE;

        // TODO: A[left] 용액을 타겟으로 지정한다. -A[left] 와 가장 비슷한 용액을 right에서 탐색한다.
        int v1 = 0, v2 = 0;
        for (int left = 1; left <= N; left++) {
            int result = lower_bound(A, left, N, -A[left]);

            // A[result - 1] 와 A[result] 중에 A[left] 와 섞었을 때의 정보를 정답에 갱신한다.
            if (left + 1 <= result - 1 && result - 1 <= N && Math.abs(A[result - 1] + A[left]) < bestSum) { // 구간 내 여부인가
                bestSum = Math.abs(A[left] + A[result - 1]);
                v1 = A[left];
                v2 = A[result - 1];
            }

            if (left + 1 <= result && result <= N && Math.abs(A[left] + A[result]) < bestSum) {
                bestSum = Math.abs(A[left] + A[result]);
                v1 = A[left];
                v2 = A[result];
            }
        }

        // TODO: 출력하기
        sb.append(v1).append(' ').append(v2);
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
