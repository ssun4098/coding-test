import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            int[][] array = new int[n+1][3];
            int[][] maxValues = new int[n+1][3];
            int[][] minValues = new int[n+1][3];

            for(int i = 1; i <= n; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < 3; j++) {
                    array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }


            for(int i = 1; i <= n; i++) {
                maxValues[i][0] += Math.max(maxValues[i-1][0], maxValues[i-1][1]) + array[i][0];
                maxValues[i][1] += Math.max(Math.max(maxValues[i-1][0], maxValues[i-1][1]), maxValues[i-1][2]) + array[i][1];
                maxValues[i][2] += Math.max(maxValues[i-1][1], maxValues[i-1][2]) + array[i][2];

                minValues[i][0] += Math.min(minValues[i-1][0], minValues[i-1][1]) + array[i][0];
                minValues[i][1] += Math.min(Math.min(minValues[i-1][0], minValues[i-1][1]), minValues[i-1][2])+ array[i][1];
                minValues[i][2] += Math.min(minValues[i-1][1], minValues[i-1][2]) + array[i][2];
            }

            int max = Math.max(Math.max(maxValues[n][0], maxValues[n][1]), maxValues[n][2]);
            int min = Math.min(Math.min(minValues[n][0], minValues[n][1]), minValues[n][2]);

            bw.write(max + " " + min);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}