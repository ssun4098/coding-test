import java.io.*;
import java.util.*;

public class Main {
    private static Map<Integer, List<Integer>> map = new HashMap<>();
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            String[] input = br.readLine().split(" ");

            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int v = Integer.parseInt(input[2]);

            visited = new boolean[n];
            for (int i = 0; i < m; i++) {
                String[] node = br.readLine().split(" ");
                int x = Integer.parseInt(node[0]);
                int y = Integer.parseInt(node[1]);
                List<Integer> list1 = map.getOrDefault(x, new ArrayList<>());
                list1.add(y);
                map.put(x, list1);

                List<Integer> list2 = map.getOrDefault(y, new ArrayList<>());
                list2.add(x);
                map.put(y, list2);

            }

            for (List<Integer> list : map.values()) {
                Collections.sort(list);
            }
            dfs(v);
            bw.write(sb.toString());

            // clear
            sb.setLength(0);
            visited = new boolean[n];
            bfs(v);

            bw.newLine();
            bw.write(sb.toString());
        }
    }

    private static void dfs(int v) {
        visited[v - 1] = true;
        sb.append(v).append(" ");

        for (int next : map.getOrDefault(v, List.of())) {
            if (!visited[next - 1]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[v - 1] = true;
        q.add(v);

        while (!q.isEmpty()) {
            int start = q.poll();
            sb.append(start).append(" ");

            for (int next : map.getOrDefault(start, List.of())) {
                if (!visited[next - 1]) {
                    visited[next - 1] = true;
                    q.add(next);
                }
            }

        }
    }
}