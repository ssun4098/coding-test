import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());

            StringTokenizer first = new StringTokenizer(br.readLine());
            StringTokenizer second = new StringTokenizer(br.readLine());

            long baseSum = 0;      // 원래 켜진 전구 밝기 합
            long maxGain = Long.MIN_VALUE;  // 뒤집어서 얻는 최대 증가량
            long currentGain = 0; // 현재 구간 증가량

            for(int i = 0; i < n; i++) {

                long light = Long.parseLong(first.nextToken());
                int state = Integer.parseInt(second.nextToken());

                long value;

                if(state == 1) {
                    baseSum += light;
                    value = -light;   // 켜져있으면 뒤집으면 손해
                } else {
                    value = light;    // 꺼져있으면 뒤집으면 이득
                }

                // Kadane
                currentGain = Math.max(value, currentGain + value);
                maxGain = Math.max(maxGain, currentGain);
            }

            System.out.println(baseSum + maxGain);
        }
    }
}