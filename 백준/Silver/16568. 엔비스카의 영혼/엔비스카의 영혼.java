import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] dp = new int[n+1];

            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int i = 0; i <= n; i++) {
                if (dp[i] == Integer.MAX_VALUE) continue;

                // 기다리기: 1명 나감
                if (i + 1 <= n) {
                    dp[i + 1] = Math.min(dp[i] + 1, dp[i + 1]);
                }

                int remaining = n - i - 1; // 1명 나간 후 남은 사람

                // a칸 새치기 (1명 나간 후 a칸 앞으로)
                if (remaining >= a && i + a + 1 <= n) {
                    dp[i + a + 1] = Math.min(dp[i] + 1, dp[i + a + 1]);
                }

                // b칸 새치기
                if (remaining >= b && i + b + 1 <= n) {
                    dp[i + b + 1] = Math.min(dp[i] + 1, dp[i + b + 1]);
                }
            }

            System.out.println(dp[n]);
        }
    }
}