import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while(true) {
                String input = br.readLine();
                if(input == null || input.isBlank()) {
                    break;
                }
                int n = Integer.parseInt(input);
                BigInteger[] dp = new BigInteger[n+1];
                if(n < 2) {
                    System.out.println(1);
                    continue;
                }
                dp[1] = BigInteger.ONE;
                dp[2] = BigInteger.valueOf(3L);

                for(int i = 3; i <= n; i++) {
                    dp[i] = dp[i-1].add(BigInteger.TWO.multiply(dp[i-2]));
                }
                System.out.println(dp[n]);
            }

        }
    }
}
