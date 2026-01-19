import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            long [][] array = new long[n+1][10];
            for(int i = 1; i <= 9; i++) {
                array[1][i] = 1;
            }
            for(int i = 2; i <= n; i++) {
                for(int j = 0; j <= 9; j++) {
                    if(j == 0) {
                        array[i][j] = array[i-1][1] % 1000000000;
                    } else if(j == 9) {
                        array[i][9] = array[i-1][8] % 1000000000;
                    } else {
                        array[i][j] = (array[i-1][j-1] + array[i-1][j+1]) % 1000000000;
                    }
                }
            }
            long answer = 0;
            for(int i = 0; i <= 9; i++) {
                answer += (array[n][i]  % 1000000000);
            }
            bw.write(String.valueOf(answer % 1000000000));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
