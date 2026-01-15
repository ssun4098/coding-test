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
            int[][] array = new int[n][m];
            boolean[][] visited = new boolean[n][m];

            for(int i = 0; i < n; i++) {
                StringTokenizer stringTokenizer1 = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < m; j++) {
                    array[i][j] = Integer.parseInt(stringTokenizer1.nextToken());
                }
            }

            int maxSize = 0;
            int count = 0;
            Deque<Node> nodeDeque = new ArrayDeque<>();

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    int size = 0;
                    if(array[i][j] == 1 && !visited[i][j]) {
                        count++;
                        visited[i][j] = true;
                        nodeDeque.add(new Node(j, i));
                        size++;
                    }
                    while(!nodeDeque.isEmpty()) {
                        Node now = nodeDeque.poll();

                        // 왼쪽
                        if(now.getX() != 0 && array[now.getY()][now.getX() - 1] == 1 && !visited[now.getY()][now.getX() - 1]) {
                            size++;
                            visited[now.getY()][now.getX() - 1] = true;
                            nodeDeque.add(new Node(now.getX() - 1, now.getY()));
                        }

                        // 오른쪽
                        if(now.getX() < m - 1 && array[now.getY()][now.getX() + 1] == 1 && !visited[now.getY()][now.getX() + 1]) {
                            size++;
                            visited[now.getY()][now.getX() + 1] = true;
                            nodeDeque.add(new Node(now.getX() + 1, now.getY()));
                        }

                        // 위
                        if(now.getY() != 0 && array[now.getY() - 1][now.getX()] == 1 && !visited[now.getY() - 1][now.getX()]) {
                            size++;
                            visited[now.getY() - 1][now.getX()] = true;
                            nodeDeque.add(new Node(now.getX(), now.getY() - 1));
                        }

                        // 아래
                        if(now.getY() != n - 1 && array[now.getY() + 1][now.getX()] == 1 && !visited[now.getY() + 1][now.getX()]) {
                            size++;
                            visited[now.getY() + 1][now.getX()] = true;
                            nodeDeque.add(new Node(now.getX(), now.getY() + 1));
                        }
                    }
                    maxSize = Math.max(maxSize, size);
                }
            }
            bw.write(String.valueOf(count));
            bw.newLine();
            bw.write(String.valueOf(maxSize));
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

