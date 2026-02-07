import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] array = new int[n];

            for(int i = 0; i < n; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());

                array[i] = b - a;
            }
            Arrays.sort(array);

            int mid = n / 2;
            int answer;

            if (n % 2 == 1) {
                answer = 1;
            } else {
                answer = array[mid] - array[mid - 1] + 1;
            }

            bufferedWriter.write(String.valueOf(answer));
        }
    }
}