import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer firstInput = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(firstInput.nextToken());
        StringTokenizer secondInput = new StringTokenizer(br.readLine(), " ");
        int[] array = new int[n+1];
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(secondInput.nextToken());
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for(int i = 1; i <= n; i++) {
            if(dp[i] == Integer.MAX_VALUE) continue;

            int value = array[i];

            for(int j = i + 1; j <= Math.min(n, i + value); j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        if(dp[n] == Integer.MAX_VALUE) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(dp[n]));
        }

        bw.flush();
    }
}