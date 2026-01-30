import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int[][] array = new int[n][2];
            boolean[] visited = new boolean[n];

            for(int i = 0; i < n; i++) {
                StringTokenizer stringTokenizer1 = new StringTokenizer(br.readLine(), " ");
                array[i][0] = Integer.parseInt(stringTokenizer1.nextToken());
                array[i][1] = Integer.parseInt(stringTokenizer1.nextToken());
            }
            for(int i = 1; i <= n; i++) {
                for(int j = 0; j < n; j++) {
                    visited = new boolean[n];
                    visited[j] = true;
                    solution(array, visited, 1, i);
                }
            }
            bw.write(String.valueOf(answer));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void solution(int[][] array, boolean[] visited, int count, int max) {
        if(count == max) {
            int value1 = 1;
            int value2 = 0;
            for(int i = 0; i < visited.length; i++) {
                if(visited[i]) {
                    value1 *= array[i][0];
                    value2 += array[i][1];
                }
            }
            answer = Math.min(Math.abs(answer), Math.abs(value1 - value2));
            return;
        }
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                solution(array, visited, count+1, max);
                visited[i] = false;
            }
        }
    }
}
