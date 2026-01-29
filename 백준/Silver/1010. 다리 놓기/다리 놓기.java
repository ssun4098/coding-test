import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int t = Integer.parseInt(br.readLine());
            for(int i = 0; i < t; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                // n개 중에 1개를 선택 항상 n <= m
                BigInteger result = fact(m).divide((fact(n).multiply(fact(m-n))));

                bw.write(String.valueOf(result));
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BigInteger fact(int n) {
        BigInteger sum = new BigInteger(String.valueOf(1));
        for(int i = 2; i <= n; i++) {
            sum = sum.multiply(new BigInteger(String.valueOf(i)));
        }
        return sum;
    }
}