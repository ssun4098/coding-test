import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n  = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int[] array = new int[n];
        int answer = 0;

        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        while(true) {
            Arrays.sort(array);

            if(array[n-1] == 0) break;

            array[n-1]--;

            if(n > 1 && array[n-2] > 0) {
                array[n-2]--;
            }

            answer++;
        }


        bw.write(String.valueOf(answer > 1440 ? -1 : answer));
        bw.flush();
    }
}