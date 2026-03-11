import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {

            int n = Integer.parseInt(br.readLine());
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(br.readLine());
            int[] coins = new int[n];
            int[] dp = new int[m+1];
            for(int j = 0; j < n; j++) {
                coins[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            dp[0] = 1;
            for(int coin : coins) {
                for(int j = coin; j <= m; j++) {
                    dp[j] += dp[j - coin];
                }
            }
            bw.write(String.valueOf(dp[m]));
            bw.newLine();
        }

        bw.flush();
    }
}
