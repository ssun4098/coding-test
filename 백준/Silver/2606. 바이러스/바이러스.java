import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int n = Integer.parseInt(br.readLine());
            Map<Integer, List<Integer>> tree = new HashMap<>();
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new ArrayDeque<>();
            int count = Integer.parseInt(br.readLine());
            for(int i = 0; i < count; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                List<Integer> link = tree.getOrDefault(x, new ArrayList<>());
                link.add(y);
                tree.put(x, link);

                List<Integer> reverse = tree.getOrDefault(y, new ArrayList<>());
                reverse.add(x);
                tree.put(y, reverse);
            }

            // 1번 컴퓨터가 걸림
            queue.add(1);
            visited[0] = true;
            int answer = 0;
            while(!queue.isEmpty()) {
                int computer = queue.poll();
                List<Integer> link = tree.getOrDefault(computer, new ArrayList<>());

                for(Integer next: link) {
                    if(!visited[next - 1]) {
                        visited[next - 1] = true;
                        queue.add(next);
                        answer++;
                    }
                }
            }
            bw.write(String.valueOf(answer));
        }
    }
}