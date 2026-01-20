import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            int[][] array = new int[n][3];
            int[][] memory = new int[n][3];

            for(int i = 0; i < n; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < 3; j++) {
                    array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            memory[0][0] = array[0][0];
            memory[0][1] = array[0][1];
            memory[0][2] = array[0][2];
            int answer = 0;
            for(int i = 1; i < n; i++) {
                memory[i][0] = array[i][0] + Math.min(memory[i-1][1], memory[i-1][2]);
                memory[i][1] = array[i][1] + Math.min(memory[i-1][0], memory[i-1][2]);
                memory[i][2] = array[i][2] + Math.min(memory[i-1][0], memory[i-1][1]);
                answer = Math.min(Math.min(memory[i][0], memory[i][1]), memory[i][2]);
            }
            bw.write(String.valueOf(answer));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}