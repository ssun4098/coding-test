import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int t = Integer.parseInt(stringTokenizer.nextToken());
        int[][] array = new int[n][2];
        int[] dp = new int[t+1];

        for(int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(br.readLine(), " ");
            array[i][0] = Integer.parseInt(stringTokenizer1.nextToken());
            array[i][1] = Integer.parseInt(stringTokenizer1.nextToken());
        }

        for(int i = 0; i < n; i++) {
            int k = array[i][0]; // 시간
            int s = array[i][1]; // 배점

            for(int j = t; j >= k; j--) {
                dp[j] = Math.max(dp[j], dp[j - k] + s);
            }
        }
        bw.write(String.valueOf(dp[t]));
        bw.flush();
    }
}