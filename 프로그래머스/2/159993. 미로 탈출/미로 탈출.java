import java.util.*;

class Solution {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public int solution(String[] maps) {

        char[][] map = new char[maps.length][maps[0].length()];

        Node start = null;
        Node lever = null;
        Node end = null;

        for (int y = 0; y < maps.length; y++) {
            for (int x = 0; x < maps[0].length(); x++) {
                map[y][x] = maps[y].charAt(x);

                if (map[y][x] == 'S') {
                    start = new Node(x, y);
                } else if (map[y][x] == 'L') {
                    lever = new Node(x, y);
                } else if (map[y][x] == 'E') {
                    end = new Node(x, y);
                }
            }
        }

        int sToL = bfs(start, lever, map);

        if (sToL == -1) {
            return -1;
        }

        int lToE = bfs(lever, end, map);

        if (lToE == -1) {
            return -1;
        }

        return sToL + lToE;
    }

    private int bfs(Node start, Node target, char[][] map) {

        int h = map.length;
        int w = map[0].length;

        int[][] dist = new int[h][w];

        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<Node> queue = new LinkedList<>();

        queue.offer(start);
        dist[start.y][start.x] = 0;

        while (!queue.isEmpty()) {

            Node cur = queue.poll();

            if (cur.x == target.x && cur.y == target.y) {
                return dist[cur.y][cur.x];
            }

            for (int i = 0; i < 4; i++) {

                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= w || ny >= h) {
                    continue;
                }

                if (map[ny][nx] == 'X') {
                    continue;
                }

                if (dist[ny][nx] != -1) {
                    continue;
                }

                dist[ny][nx] = dist[cur.y][cur.x] + 1;
                queue.offer(new Node(nx, ny));
            }
        }

        return -1;
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}