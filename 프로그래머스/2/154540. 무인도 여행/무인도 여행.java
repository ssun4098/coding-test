import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        int[][] array = new int[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        Deque<Node> q = new ArrayDeque<>();

        for (int i = 0; i < maps.length; i++) {
            String s = maps[i];

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (c == 'X') {
                    continue;
                }

                array[i][j] = c - '0';
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                if (array[i][j] != 0 && !visited[i][j]) {
                    int sum = 0;

                    q.add(new Node(j, i));
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        Node node = q.poll();

                        sum += array[node.getY()][node.getX()];

                        // 상
                        if (node.getY() > 0
                                && array[node.getY() - 1][node.getX()] > 0
                                && !visited[node.getY() - 1][node.getX()]) {

                            visited[node.getY() - 1][node.getX()] = true;
                            q.add(new Node(node.getX(), node.getY() - 1));
                        }

                        // 하
                        if (node.getY() < array.length - 1
                                && array[node.getY() + 1][node.getX()] > 0
                                && !visited[node.getY() + 1][node.getX()]) {

                            visited[node.getY() + 1][node.getX()] = true;
                            q.add(new Node(node.getX(), node.getY() + 1));
                        }

                        // 좌
                        if (node.getX() > 0
                                && array[node.getY()][node.getX() - 1] > 0
                                && !visited[node.getY()][node.getX() - 1]) {

                            visited[node.getY()][node.getX() - 1] = true;
                            q.add(new Node(node.getX() - 1, node.getY()));
                        }

                        // 우
                        if (node.getX() < array[0].length - 1
                                && array[node.getY()][node.getX() + 1] > 0
                                && !visited[node.getY()][node.getX() + 1]) {

                            visited[node.getY()][node.getX() + 1] = true;
                            q.add(new Node(node.getX() + 1, node.getY()));
                        }
                    }

                    answer.add(sum);
                }
            }
        }

        if (answer.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(answer);

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public class Node {
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