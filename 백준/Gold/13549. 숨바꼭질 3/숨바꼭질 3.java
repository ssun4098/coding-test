import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // n이 k보다 크면 뒤로 한 칸씩 걷는 수밖에 없습니다.
            if (n >= k) {
                bw.write(String.valueOf(n - k));
                return;
            }

            // 최대 범위를 100,001로 고정 (문제 조건)
            int max = 100000;
            Deque<Node> deque = new ArrayDeque<>();
            boolean[] visited = new boolean[max + 1];

            deque.add(new Node(n, 0));

            while (!deque.isEmpty()) {
                Node now = deque.poll();
                int x = now.getX();
                int sec = now.getSecond();

                // 큐에서 꺼낼 때 방문 처리 (더 짧은 경로가 먼저 나올 수 있도록)
                if (x < 0 || x > max || visited[x]) continue;
                visited[x] = true;

                if (x == k) {
                    bw.write(String.valueOf(sec));
                    break;
                }

                // 1. 순간이동 (0초): 우선순위가 높으므로 addFirst
                if (x * 2 <= max && !visited[x * 2]) {
                    deque.addFirst(new Node(x * 2, sec));
                }
                // 2. 걷기 (1초): 우선순위가 낮으므로 addLast
                if (x + 1 <= max && !visited[x + 1]) {
                    deque.addLast(new Node(x + 1, sec + 1));
                }
                if (x - 1 >= 0 && !visited[x - 1]) {
                    deque.addLast(new Node(x - 1, sec + 1));
                }
            }
        }
    }

    private static class Node {
        private int x;
        private int second;

        private Node(int x, int second) {
            this.x = x;
            this.second = second;
        }

        public int getX() { return x; }
        public int getSecond() { return second; }
    }
}