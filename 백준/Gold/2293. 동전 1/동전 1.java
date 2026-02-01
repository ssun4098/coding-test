import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(br.readLine());
            }

            int[] dp = new int[k + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int money = coin; money <= k; money++) {
                    dp[money] += dp[money - coin];
                }
            }

            bw.write(String.valueOf(dp[k]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}