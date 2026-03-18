import java.io.*;
import java.util.*;

public class Main {

    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");


        List<Node> homes = new ArrayList<>();
        List<Node> chickens = new ArrayList<>();

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        for(int i = 0; i < n; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                int value = Integer.parseInt(input.nextToken());
                if(value == 1) {
                    homes.add(new Node(j, i));
                } else if(value == 2) {
                    chickens.add(new Node(j, i));
                }
            }
        }
        int[][] array = new int[homes.size()][chickens.size()];
        boolean[] visited = new boolean[chickens.size()];
        for(int i = 0; i < array.length; i++) {
            Node home = homes.get(i);
            for(int j = 0; j < chickens.size(); j++) {
                Node chicken = chickens.get(j);
                int w = Math.abs(home.getX() - chicken.getX());
                int h = Math.abs(home.getY() - chicken.getY());
                array[i][j] = w + h;
            }
        }
        combin(array, visited, m, 0, 0);
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    public static void combin(int[][] array, boolean[] visited, int max, int now, int start) {
        if(now == max) {
            cal(array, visited);
            return;
        }
        for(int i = start; i < visited.length; i++) {
            visited[i] = true;
            combin(array, visited, max, now+1, i+1);
            visited[i] = false;
        }
    }

    public static void cal(int[][] array, boolean[] visited) {
        int sum = 0;

        for(int i = 0; i < array.length; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < visited.length; j++) {
                if(visited[j]) {
                    min = Math.min(min, array[i][j]);
                }
            }
            sum += min;
        }

        answer = Math.min(sum, answer);
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
