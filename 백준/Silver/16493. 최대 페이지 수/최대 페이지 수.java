import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[][] array = new int[m][2];
        int[] dp = new int[n + 1];
        for(int i = 0; i < m; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(br.readLine(), " ");
            array[i][0] = Integer.parseInt(stringTokenizer1.nextToken());
            array[i][1] = Integer.parseInt(stringTokenizer1.nextToken());
        }

        for(int i = 0; i < m; i++) {
            int day = array[i][0];
            int page = array[i][1];

            for(int j = n; j >= day; j--) {
                dp[j] = Math.max(dp[j], dp[j - day] + page);
            }
        }
        bw.write(String.valueOf(dp[n]));
        bw.flush();
    }
}