import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

            int m = Integer.parseInt(stringTokenizer.nextToken());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int h = Integer.parseInt(stringTokenizer.nextToken());

            int[][][] array = new int[h][n][m];
            boolean[][][] visited = new boolean[h][n][m];
            boolean allOne = true;
            Deque<Node> deque = new ArrayDeque<>();
            int day = -1;

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < n; j++) {
                    StringTokenizer stringTokenizer1 = new StringTokenizer(br.readLine(), " ");
                    for(int k = 0; k < m; k++) {
                        array[i][j][k] = Integer.parseInt(stringTokenizer1.nextToken());
                        if(array[i][j][k] == 0) {
                            allOne = false;
                        }
                        if(array[i][j][k] == 1) {
                            deque.add(new Node(k, j, i));
                        }
                    }
                }

            }
            if(allOne) {
                bw.write("0");
                return;
            }
            while(!deque.isEmpty()) {
                day++;
                int size = deque.size();
                for(int i = 0; i < size; i++) {
                    Node node = deque.poll();

                    if (node.getX() > 0
                            && array[node.getZ()][node.getY()][node.getX() - 1] == 0
                            && !visited[node.getZ()][node.getY()][node.getX() - 1]) {

                        visited[node.getZ()][node.getY()][node.getX() - 1] = true;
                        array[node.getZ()][node.getY()][node.getX() - 1] = 1;
                        deque.add(new Node(node.getX() - 1, node.getY(), node.getZ()));
                    }

                    if (node.getX() < m - 1
                            && array[node.getZ()][node.getY()][node.getX() + 1] == 0
                            && !visited[node.getZ()][node.getY()][node.getX() + 1]) {

                        visited[node.getZ()][node.getY()][node.getX() + 1] = true;
                        array[node.getZ()][node.getY()][node.getX() + 1] = 1;
                        deque.add(new Node(node.getX() + 1, node.getY(), node.getZ()));
                    }

                    if (node.getY() > 0
                            && array[node.getZ()][node.getY() - 1][node.getX()] == 0
                            && !visited[node.getZ()][node.getY() - 1][node.getX()]) {

                        visited[node.getZ()][node.getY() - 1][node.getX()] = true;
                        array[node.getZ()][node.getY() - 1][node.getX()] = 1;
                        deque.add(new Node(node.getX(), node.getY() - 1, node.getZ()));
                    }

                    if (node.getY() < n - 1
                            && array[node.getZ()][node.getY() + 1][node.getX()] == 0
                            && !visited[node.getZ()][node.getY() + 1][node.getX()]) {

                        visited[node.getZ()][node.getY() + 1][node.getX()] = true;
                        array[node.getZ()][node.getY() + 1][node.getX()] = 1;
                        deque.add(new Node(node.getX(), node.getY() + 1, node.getZ()));
                    }

                    if (node.getZ() > 0
                            && array[node.getZ() - 1][node.getY()][node.getX()] == 0
                            && !visited[node.getZ() - 1][node.getY()][node.getX()]) {

                        visited[node.getZ() - 1][node.getY()][node.getX()] = true;
                        array[node.getZ() - 1][node.getY()][node.getX()] = 1;
                        deque.add(new Node(node.getX(), node.getY(), node.getZ() - 1));
                    }

                    if (node.getZ() < h - 1
                            && array[node.getZ() + 1][node.getY()][node.getX()] == 0
                            && !visited[node.getZ() + 1][node.getY()][node.getX()]) {

                        visited[node.getZ() + 1][node.getY()][node.getX()] = true;
                        array[node.getZ() + 1][node.getY()][node.getX()] = 1;
                        deque.add(new Node(node.getX(), node.getY(), node.getZ() + 1));
                    }
                }
            }


            boolean checked = true;
            outer:
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < n; j++) {
                    for(int k = 0; k < m; k++) {
                        if(array[i][j][k] == 0) {
                            checked = false;
                            break outer;
                        }
                    }
                }
            }
            if(checked) {
                bw.write(String.valueOf(day));
            } else {
                bw.write(String.valueOf("-1"));
            }
        }
    }

    private static class Node {
        private int x;
        private int y;
        private int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }
    }
}