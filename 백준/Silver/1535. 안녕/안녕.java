import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[][] array = new int[n][2];
            int[] dp = new int[100];
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine(), " ");
            StringTokenizer stringTokenizer2 = new StringTokenizer(bufferedReader.readLine(), " ");
            for(int i = 0; i < n; i++) {
                array[i][0] = Integer.parseInt(stringTokenizer1.nextToken());
                array[i][1] = Integer.parseInt(stringTokenizer2.nextToken());
            }

            for (int i = 0; i < n; i++) {
                int w = array[i][0]; // 피로도
                int v = array[i][1]; // 재미
                
                for (int x = 99; x >= w; x--) {
                    dp[x] = Math.max(dp[x], dp[x - w] + v);
                }
            }


            int answer = Integer.MIN_VALUE;
            for(int i = 0; i < 100; i++) {
                answer = Math.max(answer, dp[i]);
            }
            bufferedWriter.write(String.valueOf(answer));
        }
    }
}