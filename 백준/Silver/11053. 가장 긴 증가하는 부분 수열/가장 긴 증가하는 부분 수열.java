import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            int[] array = new int[n];
            int[] dp = new int[n];
            dp[0] = 1;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i < n; i++) {
                dp[i] = 1;
                for(int j = 0; j < i; j++) {
                    if(array[j] < array[i] && dp[j] >= dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            int max = 0;
            for(Integer i: dp) {
                max = Math.max(i, max);
            }
            bw.write(String.valueOf(max));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}