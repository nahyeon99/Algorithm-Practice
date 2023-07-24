package nahyeon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1260_DFS와BFS {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static int[][] adj;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        adj = new int[N + 1][N+1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            // 무방향 그래프
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }

    static void bfs(int x) {
        // x 에서 시작해서 갈 수 있는 모든 정점들을 탐색한다.
        Queue<Integer> que = new LinkedList<>();

        // x 는 방문 가능한 점이므로 que 에 넣어준다.
        que.add(x);
        // x 에 갈 수 있다고 표시한다.
        visit[x] = true;

        // 더 확인할 점이 없다면 탈출한다.
        while (!que.isEmpty()) {
            // 모든 정점이 x 로 한번씩만 등장한다. O(V)
            x = que.poll();
            sb.append(x).append(' ');
            // 인접행렬 O(V) / 인접리스트 O(deg(x))
            for (int y = 1; y <= N; y++) {
                if (adj[x][y] == 0) continue;
                // x 에서 y 를 갈 수 있지만, 이미 탐색한 점이면 무시한다.
                if (visit[y]) continue;

                // y 를 갈 수 있으므로 que 에 추가하고, visit 처리한다.
                que.add(y);
                visit[y] = true;
            }
        }
    }

    // x 를 갈 수 있다는 걸 알고 방문한 상태
    // 모든 정점이 x 로 한번씩만 등장한다. O(V)
    static void dfs(int x) {
        // x 를 방문했다.
        visit[x] = true;
        sb.append(x).append(' ');

        // x 에서 갈 수 있는 곳들을 모두 방문한다.
        for (int y = 1; y <= N; y++) {
            if (adj[x][y] == 0) continue;
            // y 를 이미 방문했다면, 굳이 갈 필요가 없다.
            if (visit[y]) continue;
            // y 에서 갈 수 있는 곳들도 확인한다.
            dfs(y);
        }
    }

    static void pro() {
        dfs(V);
        sb.append('\n');

        for (int i = 1; i <= N; i++)
            visit[i] = false;

        bfs(V);
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
