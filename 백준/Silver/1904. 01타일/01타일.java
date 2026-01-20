import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());

            int[] array = new int[n+1];
            if(n == 1) {
                bw.write("1");
                return;
            }

            if(n == 2) {
                bw.write("2");
                return;
            }

            array[1] = 1;
            array[2] = 2;
            for(int i = 3; i <= n; i++) {
                array[i] = (array[i-1] + array[i-2]) % 15746;
            }
            bw.write(String.valueOf(array[n]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}