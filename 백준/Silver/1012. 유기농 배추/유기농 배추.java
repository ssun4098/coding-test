import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int t = Integer.parseInt(br.readLine());
            for(int i = 0; i < t; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
                int m = Integer.parseInt(stringTokenizer.nextToken());
                int n = Integer.parseInt(stringTokenizer.nextToken());
                int k = Integer.parseInt(stringTokenizer.nextToken());

                int[][] array = new int[n][m];
                boolean[][] visited = new boolean[n][m];

                for(int j = 0; j < k; j++) {
                    StringTokenizer coordinate = new StringTokenizer(br.readLine(), " ");
                    int x = Integer.parseInt(coordinate.nextToken());
                    int y = Integer.parseInt(coordinate.nextToken());

                    array[y][x] = 1;
                }

                Deque<Node> queue = new ArrayDeque<>();
                int answer = 0;

                for(int h = 0; h < n; h++) {
                    for(int w = 0; w < m; w++) {
                        if(array[h][w] == 1 && !visited[h][w]) {
                            queue.add(new Node(w, h));
                            answer++;
                            visited[h][w] = true;
                        }
                        while(!queue.isEmpty()) {
                            Node now = queue.poll();

                            // 왼쪽
                            if(now.getX() > 0 && array[now.getY()][now.getX() - 1] == 1 && !visited[now.getY()][now.getX() - 1]) {
                                queue.add(new Node(now.getX() - 1, now.getY()));
                                visited[now.getY()][now.getX() - 1] = true;
                            }

                            // 오른쪽
                            if(now.getX() < m - 1 && array[now.getY()][now.getX() + 1] == 1 && !visited[now.getY()][now.getX() + 1]) {
                                queue.add(new Node(now.getX() + 1, now.getY()));
                                visited[now.getY()][now.getX() + 1] = true;
                            }

                            // 위쪽
                            if(now.getY() > 0 && array[now.getY() - 1][now.getX()] == 1 && !visited[now.getY() - 1][now.getX()]) {
                                queue.add(new Node(now.getX(), now.getY() - 1));
                                visited[now.getY() - 1][now.getX()] = true;
                            }

                            // 아래쪽
                            if(now.getY() < n - 1 && array[now.getY() + 1][now.getX()] == 1 && !visited[now.getY() + 1][now.getX()]) {
                                queue.add(new Node(now.getX(), now.getY() + 1));
                                visited[now.getY() + 1][now.getX()] = true;
                            }
                        }
                    }
                }
                bw.write(String.valueOf(answer));
                bw.newLine();
            }
        }
    }

    public static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
