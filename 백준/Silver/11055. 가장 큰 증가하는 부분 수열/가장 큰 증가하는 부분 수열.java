import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            int[] array = new int[n];
            int[] dp = new int[n];
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            dp[0] = array[0];
            for(int i = 1; i < n; i++) {
                for(int j = i-1; j >= 0; j--) {
                    if(array[j] < array[i]) {
                        dp[i] = Math.max(dp[j], dp[i]);
                    }
                }
                dp[i] += array[i];
            }
            bw.write(String.valueOf(Arrays.stream(dp).max().getAsInt()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}