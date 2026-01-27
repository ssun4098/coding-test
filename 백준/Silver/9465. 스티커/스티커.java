import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int t = Integer.parseInt(br.readLine());
            for(int i = 0; i < t; i++) {

                int n = Integer.parseInt(br.readLine());
                int[][] array = new int[2][n + 1];
                int[][] dp = new int[2][n + 1];
                for(int j = 0; j < 2; j++) {
                    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
                    for(int k = 1; k <= n; k++) {
                        array[j][k] = Integer.parseInt(stringTokenizer.nextToken());
                    }
                }

                dp[0][1] = array[0][1];
                dp[1][1] = array[1][1];

                for(int j = 2; j <= n; j++) {
                    int beforeMax = Math.max(dp[0][j-2], dp[1][j-2]);
                    dp[0][j] = Math.max(dp[1][j-1] + array[0][j], beforeMax + array[0][j]);
                    dp[1][j] = Math.max(dp[0][j-1] + array[1][j], beforeMax + array[1][j]);
                }
                bw.write(String.valueOf(Math.max(dp[0][n], dp[1][n])));
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
