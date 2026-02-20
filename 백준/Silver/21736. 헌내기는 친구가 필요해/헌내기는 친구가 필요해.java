import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            String[][] campus = new String[n][m];
            boolean[][] visited = new boolean[n][m];
            Coordinate start = null;
            Deque<Coordinate> deque = new ArrayDeque<>();
            for(int i = 0; i < n; i++) {
                String input = bufferedReader.readLine();
                for(int j = 0; j < m; j++) {
                    campus[i][j] = String.valueOf(input.charAt(j));
                    if(campus[i][j].equals("I")) {
                        start = new Coordinate(j, i);
                        visited[i][j] = true;
                    }
                }
            }
            deque.add(start);
            int answer = 0;
            while(!deque.isEmpty()) {
                Coordinate now = deque.pollFirst();
                if(campus[now.getY()][now.getX()].equals("P")) {
                    answer++;
                }

                // 상
                if(now.getY() > 0 && !campus[now.getY() - 1][now.getX()].equals("X") && !visited[now.getY() - 1][now.getX()]) {
                    deque.add(new Coordinate(now.getX(), now.getY() - 1));
                    visited[now.getY() - 1][now.getX()] = true;
                }

                // 하
                if(now.getY() < n - 1 && !campus[now.getY() + 1][now.getX()].equals("X") && !visited[now.getY() + 1][now.getX()]) {
                    deque.add(new Coordinate(now.getX(), now.getY() + 1));
                    visited[now.getY() + 1][now.getX()] = true;
                }

                // 좌
                if(now.getX() > 0 && !campus[now.getY()][now.getX() - 1].equals("X") && !visited[now.getY()][now.getX() - 1]) {
                    deque.add(new Coordinate(now.getX() - 1, now.getY()));
                    visited[now.getY()][now.getX() - 1] = true;
                }

                // 우
                if(now.getX() < m - 1 && !campus[now.getY()][now.getX() + 1].equals("X") && !visited[now.getY()][now.getX() + 1]) {
                    deque.add(new Coordinate(now.getX() + 1, now.getY()));
                    visited[now.getY()][now.getX() + 1] = true;
                }
            }
            if(answer == 0) {
                bufferedWriter.write("TT");
            } else {
                bufferedWriter.write(String.valueOf(answer));
            }
        }
    }

    public static class Coordinate {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
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