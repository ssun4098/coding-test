import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int d = Integer.parseInt(stringTokenizer.nextToken());
            Road[] roads = new Road[n];
            int[] dp = new int[d+1];

            for(int i = 0; i < n; i++) {
                StringTokenizer input = new StringTokenizer(bufferedReader.readLine(), " ");
                roads[i] = new Road(
                        Integer.parseInt(input.nextToken()),
                        Integer.parseInt(input.nextToken()),
                        Integer.parseInt(input.nextToken())
                );
            }

            for(int i = 1; i <= d; i++) {
                dp[i] = i;
            }

            for(int i = 0; i <= d; i++) {
                // 이전에 지름길을 탔을 경우
                if(i > 0 && dp[i-1] != i - 1) {
                    dp[i] = Math.min(dp[i-1] + 1, dp[i]);
                }
                for(int j = 0; j < n; j++) {
                    if(roads[j].getStart() != i || roads[j].getEnd() > d) {
                        continue;
                    }
                    // 지름길을 탈 수 있을 경우
                    dp[roads[j].getEnd()] = Math.min(dp[roads[j].getEnd()], dp[i] + roads[j].getDistance());
                }
            }
            bufferedWriter.write(String.valueOf(dp[d]));
        }
    }

    public static class Road {
        private int start;
        private int end;
        private int distance;

        public Road(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getDistance() {
            return distance;
        }
    }


}
