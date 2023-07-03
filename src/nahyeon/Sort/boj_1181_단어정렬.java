package nahyeon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1181_단어정렬 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] a;

    static void input() {
        N = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.next();
        }
    }

    static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            if (o1.length() != o2.length())
                return o1.length() - o2.length();
            return o1.compareTo(o2);
        }
    }
    

    static void pro() {
        // TODO: 정렬하기
        Arrays.sort(a, new MyComparator());

        //TODO: 출력하기
        for (int i = 0; i < N; i++) {
            // 중복된 단어는 하나만 남기고 제거
            if (i == 0 || a[i].compareTo(a[i-1]) != 0) {
                sb.append(a[i]).append('\n');
            }
            System.out.println(sb.toString());
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
