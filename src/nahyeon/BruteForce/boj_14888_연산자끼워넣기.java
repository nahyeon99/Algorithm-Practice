package nahyeon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14888_연산자끼워넣기 {

    static FastReader scan = new FastReader();

    static int N, max, min;
    static int[] nums, operators, order;

    static void input() {
        N = scan.nextInt();
        nums = new int[N+1];
        operators = new int[5];
        order = new int[N];

        for (int i = 1; i <= N; i++)
            nums[i] = scan.nextInt();

        for (int i = 1; i <= 4; i++)
            operators[i] = scan.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int calculator(int operand1, int operator, int operand2) {
        if (operator == 1) {
            return operand1 + operand2;
        } else if (operator == 2) {
            return operand1 - operand2;
        } else if (operator == 3) {
            return operand1 * operand2;
        } else {
            return operand1 / operand2;
        }
    }

    static void rec_func(int k, int value) {
        if (k == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int cand = 1; cand <= 4; cand++) {
                if (operators[cand] >= 1) {
                    operators[cand]--;
                    order[k] = cand;
                    int new_value = calculator(value, cand, nums[k+1]);
                    rec_func(k+1, new_value);
                    operators[cand]++;
                    order[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1, nums[1]);
        System.out.println(max);
        System.out.println(min);
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String nextLine() {
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
