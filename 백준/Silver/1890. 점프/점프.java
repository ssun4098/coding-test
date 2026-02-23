import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][n];
        long[][] dp = new long[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        dp[0][0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                int val = array[i][j]; // 이동 가능한 거리
                if(dp[i][j] == 0 || val == 0) {
                    continue;
                }


                if(val + j < n) {
                    dp[i][val + j] += dp[i][j];
                }

                // 아래로 이동
                if(val + i < n) {
                    dp[val + i][j] += dp[i][j];
                }
            }
        }
        bw.write(String.valueOf(dp[n-1][n-1]));
        bw.flush();
    }
}
