import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static int[] visited;
    static int visitId = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 뒤집기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            graph[y].add(x);
        }

        visited = new int[n];

        int max = 0;
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            visitId++;
            int count = bfs(i, n);

            if (count > max) {
                max = count;
                answer.clear();
                answer.add(i + 1);
            } else if (count == max) {
                answer.add(i + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int v : answer) sb.append(v).append(" ");
        System.out.println(sb);
    }

    static int bfs(int start, int n) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = visitId;

        int count = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (visited[next] != visitId) {
                    visited[next] = visitId;
                    count++;
                    q.offer(next);
                }
            }
        }
        return count;
    }
}
