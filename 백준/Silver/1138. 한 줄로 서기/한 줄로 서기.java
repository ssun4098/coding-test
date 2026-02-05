import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            int[] values = new int[n];
            int[] answer = new int[n];
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < n; i++) {
                values[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            answer[values[0]] = 1;
            for(int i =  1; i < n; i++) {
                int value = values[i];
                int counter = 0;
                for(int j = 0; j < n; j++) {
                    if((value == 0 && answer[j] == 0) || (value == counter && answer[j] == 0)) {
                        answer[j] = i + 1;
                        break;
                    }

                    if(answer[j] > i || answer[j] == 0) {
                        counter++;
                    }
                }
            }
            for(Integer i: answer) {
                bw.write(i + " ");
            }
        }
    }
}