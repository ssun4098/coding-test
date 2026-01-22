import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            Set<Integer> coins = new HashSet<>();
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int value = Integer.parseInt(stringTokenizer.nextToken());
            int[] df = new int[value + 1];
            for(int i = 0; i < n; i++) {
                coins.add(Integer.parseInt(br.readLine()));
            }
            Arrays.fill(df, -1);
            df[0] = 0;

            for(int i = 1; i <= value; i++) {
                for(Integer coin: coins) {
                    int result = i - coin;
                    if(result < 0) {
                        continue;
                    }
                    int otherCoinValue = df[result];
                    if(otherCoinValue == -1) {
                        continue;  // 만들 수 없는 경우는 건너뛰기
                    }


                    if(df[i] == -1) {
                        df[i] = otherCoinValue + 1;
                    } else {
                        df[i] = Math.min(otherCoinValue + 1, df[i]);
                    }
                }
            }
            bw.write(String.valueOf(df[value]));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}