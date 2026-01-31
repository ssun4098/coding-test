import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int m = Integer.parseInt(br.readLine());
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(br.readLine());
            int[] array = new int[m];
            int total = 0;
            for(int i = 0; i < m; i++) {
                array[i] = Integer.parseInt(stringTokenizer.nextToken());
                total += array[i];
            }
            double answer = 0;

            for(int i = 0; i < array.length; i++) {
                if(array[i] < k) {
                    continue;
                }
                double sum = 1.0;
                for(int j = 0; j < k; j++) {
                    sum *= (double) (array[i] - j) / (total - j);
                }
                answer += sum;
            }

            bw.write(String.valueOf(answer));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}