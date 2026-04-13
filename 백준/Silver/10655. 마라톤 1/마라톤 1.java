import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int[] y = new int[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        
        int total = 0;
        for(int i = 0; i < n - 1; i++) {
            total += manhattanDistance(x[i], y[i], x[i+1], y[i+1]);
        }

        int answer = Integer.MAX_VALUE;
        
        for(int i = 1; i < n - 1; i++) {
            int removed = manhattanDistance(x[i-1], y[i-1], x[i], y[i]) + manhattanDistance(x[i], y[i], x[i+1], y[i+1]);

            int added = manhattanDistance(x[i-1], y[i-1], x[i+1], y[i+1]);

            int newSum = total - removed + added;

            answer = Math.min(answer, newSum);
        }

        System.out.println(answer);
    }

    private static int manhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}