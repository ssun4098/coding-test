import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int t = Integer.parseInt(bufferedReader.readLine());
            for(int i = 0; i < t; i++) {
                int n = Integer.parseInt(bufferedReader.readLine());
                long[][] dp = new long[10][n];
                for(int j = 0; j < 10; j++) {
                    dp[j][0] = 1;
                }
                for(int j = 1; j < n; j++) {
                    for(int k = 0; k < 10; k++) {
                        if(k == 0) {
                            dp[k][j] = 1;
                            continue;
                        }
                        for(int a = 0; a <= k; a++) {
                            dp[k][j] += dp[a][j-1];
                        }
                    }
                }
                long answer = 0;
                for(int j = 0; j < 10; j++) {
                    answer += dp[j][n-1];
                }
                bufferedWriter.write(String.valueOf(answer));
                bufferedWriter.newLine();
            }
        }
    }
}