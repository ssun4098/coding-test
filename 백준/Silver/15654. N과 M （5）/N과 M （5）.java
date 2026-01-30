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
            int count = 0;
            for(int i = 0; i < n; i++) {
                visited = new boolean[n];
                visited[i] = true;
                count  = 1;
                recusion(array, visited, String.valueOf(array[i]), count, m);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void recusion(int[] array, boolean[] visited, String s, int count, int m) {
        if(count == m) {
            System.out.println(s);
            return;
        }

        for(int i = 0; i < array.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                recusion(array, visited, s + " " + array[i], count+1, m);
                visited[i] = false;
            }
        }
    }
}
