import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] array = new int[n];
            int[] newArray = new int[n];
            int answer = Integer.MIN_VALUE;
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                array[j] = Integer.parseInt(stringTokenizer.nextToken());
            }
            Arrays.sort(array);
            for(int j = 0; j < n; j++) {
                if(j % 2 == 0) {
                    newArray[j / 2] = array[j];
                } else {
                    newArray[n - (j / 2 + j % 2)] = array[j];
                }
            }
            for(int j = 0; j < n; j++) {
                answer = Math.max(answer, Math.abs(newArray[j % n] - newArray[(j + 1) % n]));
            }

            bw.write(String.valueOf(answer));
            bw.newLine();
        }
        bw.flush();
    }
}