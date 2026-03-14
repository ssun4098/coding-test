import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int t = Integer.parseInt(stringTokenizer.nextToken());
        int[] wArray = new int[n];
        int[] vArray = new int[n];
        int[] dp = new int[t+1];

        for(int i = 0; i < n; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            wArray[i] = Integer.parseInt(input.nextToken());
            vArray[i] = Integer.parseInt(input.nextToken());
        }

        for(int i = 0; i < n; i++) {
            for(int j = t; j >= wArray[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - wArray[i]] + vArray[i]);
            }
        }

        bw.write(String.valueOf(dp[t]));
        bw.flush();
    }
}