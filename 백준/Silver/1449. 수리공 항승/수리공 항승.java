import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        StringTokenizer stringTokenizer1 = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int l = Integer.parseInt(stringTokenizer.nextToken());
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer1.nextToken());
        }
        Arrays.sort(array);
        double lEndPoint = array[0] - 0.5 + l;
        int count = 1;
        for(int i = 1; i < n; i++) {
            double nowEndPoint = array[i] + 0.5;
            if(nowEndPoint > lEndPoint) {
                count++;
                lEndPoint = array[i] - 0.5 + l;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }
}