import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {

            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(stringTokenizer.nextToken());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int[][] array = new int[y][x];
            boolean[][] visited;
            Queue<Node> queue = new ArrayDeque<>();

            for(int i = 0; i < y; i++) {
                StringTokenizer stringTokenizer1 = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < x; j++) {
                    array[i][j] = Integer.parseInt(stringTokenizer1.nextToken());
                }
            }
            int count = 0;
            int lastCheeseSize = 0;

            while(true) {
                count++;
                queue.add(new Node(0, 0));
                visited = new boolean[y][x];
                visited[0][0] = true;
                int currentCheeseSize = 0;

                while(!queue.isEmpty()) {
                    Node now = queue.poll();

                    // 왼쪽
                    if(now.getX() > 0) {
                        if(!visited[now.getY()][now.getX() - 1]) {
                            visited[now.getY()][now.getX() - 1] = true;
                            if(array[now.getY()][now.getX() - 1] == 0) {
                                queue.add(new Node(now.getX() - 1, now.getY()));
                            } else {
                                array[now.getY()][now.getX() - 1] = 0;
                                currentCheeseSize++;
                            }
                        }
                    }

                    // 위쪽
                    if(now.getY() > 0) {
                        if(!visited[now.getY() - 1][now.getX()]) {
                            visited[now.getY() - 1][now.getX()] = true;
                            if(array[now.getY() - 1][now.getX()] == 0) {
                                queue.add(new Node(now.getX(), now.getY() - 1));
                            } else {
                                array[now.getY() - 1][now.getX()] = 0;
                                currentCheeseSize++;
                            }
                        }
                    }

                    // 아래쪽
                    if(now.getY() < array.length - 1) {
                        if(!visited[now.getY() + 1][now.getX()]) {
                            visited[now.getY() + 1][now.getX()] = true;
                            if(array[now.getY() + 1][now.getX()] == 0) {
                                queue.add(new Node(now.getX(), now.getY() + 1));
                            } else {
                                array[now.getY() + 1][now.getX()] = 0;
                                currentCheeseSize++;
                            }
                        }
                    }

                    // 오른쪽
                    if(now.getX() < array[0].length - 1) {
                        if(!visited[now.getY()][now.getX() + 1]) {
                            visited[now.getY()][now.getX() + 1] = true;
                            if(array[now.getY()][now.getX() + 1] == 0) {
                                queue.add(new Node(now.getX() + 1, now.getY()));
                            } else {
                                array[now.getY()][now.getX() + 1] = 0;
                                currentCheeseSize++;
                            }
                        }
                    }
                }

                if(currentCheeseSize == 0) {
                    break;
                }
                lastCheeseSize = currentCheeseSize;
            }
            bw.write(count - 1 + "\n" + lastCheeseSize);
        }
    }

    private static class Node {
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
