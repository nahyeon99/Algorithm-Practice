package nahyeon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1015_수열정렬 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] P;
    static Elem[] B;

    static void input() {
        N = scan.nextInt();

        B = new Elem[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = new Elem();
            // TODO: Elem의 정의에 맞게 B[i]에 값 넣어주기
            B[i].num = scan.nextInt();
            B[i].idx = i; // 처음에는 A 배열
        }
    }

    static class Elem implements Comparable<Elem> {

        public int num, idx;

        @Override
        public int compareTo(Elem other) {
            // 정렬 조건
            // 1. num 의 비내림차순
            // 2. num이 같으면 idx 오름차순

//            if (num != other.num)
//                return num - other.num;
//
//            return idx - other.idx; // Java의 Object는 오름차순 정렬이 default

            return num - other.num;
        }
    }

    static void pro() {

        // TODO: B 배열 정렬하기
        Arrays.sort(B);

        // TODO: B 배열의 값을 이용하여 P 배열 채우기
        for (int b_idx = 0; b_idx < N; b_idx++) {
            P[B[b_idx].idx] = b_idx;
        }

        // TODO: P 배열 출력하기
        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(' ');
        }
        System.out.println(sb.toString());
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
