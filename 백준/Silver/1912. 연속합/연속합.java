import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int[] array = new int[n];
            for(int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            int[] memory = new int[n];
            memory[0] = array[0];

            for(int i = 1; i < n; i++) {
                memory[i] = Math.max(array[i] + memory[i-1], array[i]);
            }
            int answer = Integer.MIN_VALUE;

            for(Integer i: memory) {
                answer = Math.max(answer, i);
            }

            bw.write(String.valueOf(answer));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}