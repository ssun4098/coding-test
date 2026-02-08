import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int[] array = new int[n+1];
            int[] dp = new int[n+1];
            for(int i = 1; i <= n; i++) {
                array[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            Arrays.fill(dp, 1);

            for(int i = 1; i <= n; i++) {
                for(int j = 1; j < i; j++) {
                    if(array[j] >= array[i]) {
                        continue;
                    }
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            bufferedWriter.write(String.valueOf(Arrays.stream(dp).max().getAsInt()));
        }
    }
}