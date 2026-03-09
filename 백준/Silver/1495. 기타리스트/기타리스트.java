import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer firstInput = new StringTokenizer(br.readLine(), " ");
        StringTokenizer secondInput = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(firstInput.nextToken());
        int s = Integer.parseInt(firstInput.nextToken());
        int m = Integer.parseInt(firstInput.nextToken());

        int[] array = new int[n + 1];
        boolean[][] dp = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(secondInput.nextToken());
        }

        dp[0][s] = true;

        for (int i = 1; i <= n; i++) {
            int value = array[i];

            for (int v = 0; v <= m; v++) {
                if (!dp[i - 1][v]) continue;

                if (v + value <= m) {
                    dp[i][v + value] = true;
                }

                if (v - value >= 0) {
                    dp[i][v - value] = true;
                }
            }
        }

        int answer = -1;

        for (int v = 0; v <= m; v++) {
            if (dp[n][v]) {
                answer = Math.max(answer, v);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
