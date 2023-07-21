package nahyeon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16472_고냥이 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, kind;
    static String A;
    static int[] cnt;

    static void input() {
        N = scan.nextInt();
        A = scan.nextLine();
        cnt = new int[26];
    }

    static void add(char x) { // x 라는 알파벳 추가
        cnt[x-'a']++;
    }

    static void erase(char x) { // x 라는 알파벳 제거
        cnt[x-'a']--;
    }

    static void pro() {
        int length = A.length(), ans = 0;
        for (int R = 0, L = 0; R < length; R++) {
            // R 번째 문자를 오른쪽에 추가
            add(A.charAt(R));

            // 불가능하면, 가능할 때까지 L을 이동
            while (true) {
                kind = 0;
                for (int i = 0; i < 26; i++) {
                    if (cnt[i] != 0)
                        kind++;
                }
                if (kind <= N) break;

                erase(A.charAt(L ));
                L++;
            }

            // 탈출 시 kind 의 개수가 N 에 만족한다는 뜻 이므로
            // 정답을 갱신한다.
            ans = Math.max(ans, R - L + 1);
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
