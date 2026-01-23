import java.io.*;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n+1];
            for (int i = 1; i <= n; i++) {
                dp[i] = i; // 최악의 경우: 1^2을 i번
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }

            bw.write(String.valueOf(dp[n]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}