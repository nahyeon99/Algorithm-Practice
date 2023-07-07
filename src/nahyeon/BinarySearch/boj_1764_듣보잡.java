package nahyeon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1764_듣보잡 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, ans;
    static String[] A, B;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        A = new String[N + 1];
        B = new String[M + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = scan.next();
        }
        for (int i = 1; i <= M; i++) {
            B[i] = scan.next();
        }
    }

    static boolean search(String[] B, int L, int R, String X) {
        // B[L...R] 에서 X 의 존재 여부를 탐색한다.
        // 존재하면 true 를, 존재하지 않으면 false 를 리턴한다.
        while (L <= R) {
            int mid = (L + R) / 2;

            int compare = X.compareTo(B[mid]);
            if (compare == 0) return true;
            else if (compare < 0) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return false;
    }

    static void pro() {
        // 1-1. A 배열 오름차순 정렬
        Arrays.sort(A, 1, N + 1);

        // 1-2. B 배열 오름차순 정렬
        Arrays.sort(B, 1, M + 1);

        // 2. A 배열을 반복문 돌리면서, B 배열에서 존재 여부를 이분탐색을 활용하여 탐색한다.
        // 존재하면 ans와 출력값을 갱신한다.
        for (int a_idx = 1; a_idx <= N; a_idx++) {
            // A[a_idx] 를 B에서 존재 여부를 탐색한다.
            boolean result = search(B, 1, M, A[a_idx]);

            // 존재하면 출력값을 갱신한다.
            if (result) {
                ans++;
                sb.append(A[a_idx]).append('\n');
            }
        }

        // 3. ans와 sb를 출력한다.
        System.out.println(ans);
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
