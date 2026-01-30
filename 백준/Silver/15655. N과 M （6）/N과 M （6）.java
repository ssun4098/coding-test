import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            int[] array = new int[n];
            boolean[] visited = new boolean[n];
            StringTokenizer values = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(values.nextToken());
            }

            Arrays.sort(array);

            for(int i = 0; i < array.length; i++) {
                visited = new boolean[n];
                visited[i] = true;
                solution(array, visited, 1, m, i, String.valueOf(array[i]));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void solution(int[] array, boolean[] visited, int count, int depth, int start, String s) {
        if(count == depth) {
            System.out.println(s);
            return;
        }
        for(int i = start; i < array.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                solution(array, visited, count+1, depth, i+1, s + " " + array[i]);
                visited[i] = false;
            }
        }
    }
}
