import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[][] array = new int[2][n];
            int[] work = new int[n + 1]; // 하루 여유

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
                array[0][i] = Integer.parseInt(st.nextToken());
                array[1][i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                work[i + 1] = Math.max(work[i + 1], work[i]);
                
                int end = i + array[0][i];
                if (end <= n) {
                    work[end] = Math.max(work[end], work[i] + array[1][i]);
                }
            }

            bufferedWriter.write(String.valueOf(work[n]));
        }
    }
}