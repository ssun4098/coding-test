import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken()); // 가로
            int m = Integer.parseInt(st.nextToken()); // 세로
            char[][] soldiers = new char[m][n];

            for(int i = 0; i < m; i++) {
                String s = br.readLine();
                for(int j = 0; j < n; j++) {
                    soldiers[i][j] = s.charAt(j);
                }
            }
            int w = bfs(soldiers, 'W');
            int b = bfs(soldiers, 'B');
            System.out.println(w + " " + b);
        }
    }

    public static int bfs(char[][] soldiers, char color) {
        int sum = 0;
        boolean[][] visited = new boolean[soldiers.length][soldiers[0].length];
        Deque<Node> nodes = new ArrayDeque<>();

        for(int i = 0; i < soldiers.length; i++) {
            for(int j = 0; j < soldiers[0].length; j++) {
                int count = 0;
                if(soldiers[i][j] == color && !visited[i][j]) {
                    nodes.add(new Node(j, i));
                    visited[i][j] = true;
                    count++;
                }
                while(!nodes.isEmpty()) {
                    Node node= nodes.poll();

                    // 상
                    if(node.getY() > 0
                            && soldiers[node.getY() - 1][node.getX()] == color
                            && !visited[node.getY() - 1][node.getX()]) {
                        nodes.add(new Node(node.getX(), node.getY() - 1));
                        visited[node.getY() - 1][node.getX()] = true;
                        count++;
                    }

                    // 하
                    if(node.getY() <  soldiers.length - 1
                            && soldiers[node.getY() + 1][node.getX()] == color
                            && !visited[node.getY() + 1][node.getX()]) {
                        nodes.add(new Node(node.getX(), node.getY() + 1));
                        visited[node.getY() + 1][node.getX()] = true;
                        count++;
                    }

                    // 좌
                    if(node.getX() > 0
                            && soldiers[node.getY()][node.getX() - 1] == color
                            && !visited[node.getY()][node.getX() - 1]) {
                        nodes.add(new Node(node.getX() - 1, node.getY()));
                        visited[node.getY()][node.getX() - 1] = true;
                        count++;
                    }

                    // 우
                    if(node.getX() < soldiers[0].length - 1
                            && soldiers[node.getY()][node.getX() + 1] == color
                            && !visited[node.getY()][node.getX() + 1]) {
                        nodes.add(new Node(node.getX() + 1, node.getY()));
                        visited[node.getY()][node.getX() + 1] = true;
                        count++;
                    }
                }
                sum += count * count;
            }
        }

        return sum;
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