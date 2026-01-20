import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            int[][] array = new int[n + 1][10];

            if(n == 1) {
                bw.write("10");
                return;
            }

            if(n == 2) {
                bw.write("55");
                return;
            }

            for(int i = 0; i < 10; i++) {
                array[1][i] = 1;
                array[2][i] = 10 - i;
            }
            for(int i = 3; i <= n; i++) {
                int sum = 0;
                for(int j = 0; j < 10; j++) {
                    sum = (sum + array[i-1][j]) % 10007;
                }
                array[i][0] = sum;
                for(int j = 1; j < 10; j++) {
                    array[i][j] = (array[i][j-1] - array[i-1][j-1] + 10007) % 10007;
                }
            }
            int answer = 0;
            for(int i = 0; i < 10; i++) {
                answer = (answer + array[n][i]) % 10007;
            }
            bw.write(String.valueOf(answer));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}