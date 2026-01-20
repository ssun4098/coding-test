import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            long[] array = new long[n + 1];
            long[][] memory = new long[n + 1][3];

            for(int i = 1; i <= n; i++) {
                array[i] = Integer.parseInt(br.readLine());
            }

            if (n == 1) {
                bw.write(String.valueOf(array[1]));
                return;
            }

            memory[1][1] = array[1];

            for(int i = 2; i <= n; i++) {
                // 0번 연속으로 마실 겨우
                memory[i][0] = Math.max(Math.max(memory[i-1][0], memory[i-1][1]), memory[i-1][2]);

                // 1번 연속 마실 경우
                memory[i][1] = memory[i-1][0] + array[i];

                // 2번 연속 마실 경우
                memory[i][2] = memory[i-1][1]  + array[i];
            }
            long answer = -1;
            for(int i = 0; i < 3; i++) {
                answer = Math.max(answer, memory[n][i]);
            }
            bw.write(String.valueOf(answer));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}