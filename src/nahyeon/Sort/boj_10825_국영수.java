package nahyeon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10825_국영수 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Elem[] a;

    static void input() {
        N = scan.nextInt();
        a = new Elem[N];
        for (int i = 0; i < N; i++) {
            a[i] = new Elem();
            a[i].name = scan.next();
            a[i].korean = scan.nextInt();
            a[i].english = scan.nextInt();
            a[i].math = scan.nextInt();
        }
    }

    static class Elem implements Comparable<Elem> {

        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Elem o) {
            // 1. 국어 내림차순
            if (korean != o.korean) return o.korean - korean;

            // 2. 영어 오름차순
            if (english != o.english) return english - o.english;

            // 3. 수학 내림차순
            if (math != o.math) return o.math - math;

            // 4. 이름 오름차순
            return name.compareTo(o.name);
        }
    }

    static void pro() {

        // 정렬하기
        Arrays.sort(a);
        // 결과 출력하기
        for (int i = 0; i < N; i++) {
            sb.append(a[i].name).append('\n');
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
