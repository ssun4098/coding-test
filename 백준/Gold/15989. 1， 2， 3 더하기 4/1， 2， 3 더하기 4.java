import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int t = Integer.parseInt(bufferedReader.readLine());
            for(int i = 0; i < t; i++) {
                int n = Integer.parseInt(bufferedReader.readLine());
                if(n == 1 || n == 2 || n == 3) {
                    bufferedWriter.write(String.valueOf(n));
                    bufferedWriter.newLine();
                    continue;
                }
                int[] dp = new int[n + 1];
                dp[0] = 1;

                int[] coins = {1, 2, 3};

                for (int coin : coins) {
                    for (int j = coin; j <= n; j++) {
                        dp[j] += dp[j - coin];
                    }
                }
                bufferedWriter.write(String.valueOf(dp[n]));
                bufferedWriter.newLine();
            }
        }
    }
}