import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());

            int[][] array = new int[n][m];
            boolean[][] visited = new boolean[n][m];


            for(int i = 0; i < k; i++) {
                StringTokenizer coord = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(coord.nextToken());
                int y1 = Integer.parseInt(coord.nextToken());
                int x2 = Integer.parseInt(coord.nextToken());
                int y2 = Integer.parseInt(coord.nextToken());

                for(int h = y1; h < y2; h++) {
                    for(int w = x1; w < x2; w++) {
                        array[h][w] = 1;
                    }
                }
            }

            int count = 0;
            List<Integer> size = new ArrayList<>();
            Deque<Node> queue = new ArrayDeque<>();

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(array[i][j] == 0 && !visited[i][j]) {
                        count++;
                        queue.add(new Node(j, i));
                        visited[i][j] = true;
                    }
                    int totalCount = 0;
                    while(!queue.isEmpty()) {
                        Node now = queue.poll();
                        totalCount++;
                        // 왼쪽
                        if(now.getX() > 0 && array[now.getY()][now.getX() - 1] == 0 && !visited[now.getY()][now.getX() - 1]) {
                            visited[now.getY()][now.getX() - 1] = true;
                            queue.add(new Node(now.getX() - 1, now.getY()));
                        }

                        // 오른쪽
                        if(now.getX() < m - 1 && array[now.getY()][now.getX() + 1] == 0 && !visited[now.getY()][now.getX() + 1]) {
                            visited[now.getY()][now.getX() + 1] = true;
                            queue.add(new Node(now.getX() + 1, now.getY()));
                        }

                        // 위
                        if(now.getY() > 0 && array[now.getY() - 1][now.getX()] == 0 && !visited[now.getY() - 1][now.getX()]) {
                            visited[now.getY() - 1][now.getX()] = true;
                            queue.add(new Node(now.getX(), now.getY() - 1));
                        }

                        // 아래
                        if(now.getY() < n - 1 && array[now.getY() + 1][now.getX()] == 0 && !visited[now.getY() + 1][now.getX()]) {
                            visited[now.getY() + 1][now.getX()] = true;
                            queue.add(new Node(now.getX(), now.getY() + 1));
                        }

                    }
                    if(totalCount != 0) {
                        size.add(totalCount);
                    }
                }
            }

            bw.write(String.valueOf(count));
            bw.newLine();
            Collections.sort(size);
            for (Integer s: size) {
                bw.write(s + " ");
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
