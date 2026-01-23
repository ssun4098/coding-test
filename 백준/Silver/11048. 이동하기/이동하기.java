import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            int[][] array = new int[n][m];
            int[][] dp = new int[n][m];
            for(int i = 0; i < n; i++) {
                StringTokenizer stringTokenizer1 = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < m; j++) {
                    array[i][j] = Integer.parseInt(stringTokenizer1.nextToken());
                }
            }
            dp[0][0] = array[0][0];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(i == 0 && j == 0) {
                        continue;
                    }
                    if(j == 0) {
                        dp[i][j] = dp[i-1][j] + array[i][j];
                    } else if(i == 0) {
                        dp[i][j] = dp[i][j-1] + array[i][j];
                    } else {
                        dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + array[i][j];
                    }
                }
            }
            bw.write(String.valueOf(dp[n-1][m-1]));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}