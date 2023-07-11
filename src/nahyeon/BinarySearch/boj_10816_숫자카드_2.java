package nahyeon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10816_숫자카드_2 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] NArr;

    static void input() {
        N = scan.nextInt();
        NArr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            NArr[i] = scan.nextInt();
        }
    }

    static int checkAdjacentElement (int x, int index) {
        // x 와 a[인덱스]가 같은지 비교합니다.
        int cnt = 0;
        // upper_bound check: index 를 기점으로 위쪽 인덱스들을 체크합니다.
        for (int i = index + 1; i < NArr.length; i++) {
            if (NArr[i] == x)
                cnt++;
            else
                break;
        }

        // lower_bound check: index 를 기점으로 아래쪽 인덱스들을 체크합니다.
        for (int i = index - 1; i >= 1; i--) {
            if (NArr[i] == x)
                cnt++;
            else
                break;
        }
        return cnt;
    }

    static int search(int x) {

        // NArr[L...R] 에서 X 가 존재하는지 이분탐색한다.
        // 존재한다면 정렬된 NArr 의 인접원소들 중에도 X 가 있는지 확인 후, 존재하면 cnt 를 갱신하여 반환한다.

        int L = 1, R = NArr.length - 1, cnt = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (NArr[mid] == x) {
                int adjacentElemCnt = checkAdjacentElement(x, mid);
                cnt = cnt + 1 + adjacentElemCnt;
                return cnt;
            } else if (NArr[mid] < x) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return cnt;
    }

    static void pro() {
        // N 배열 정렬하기
        Arrays.sort(NArr, 1, N + 1);

        int M = scan.nextInt();
        for (int i = 1; i <= M; i++) {
            int M_elem = scan.nextInt();
            int cnt = search(M_elem);
            sb.append(cnt).append(' ');
        }
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
