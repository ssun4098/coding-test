import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int n = Integer.parseInt(br.readLine());

            if (n == 1) {
                bw.write("2");
                return;
            }

            if (n == 2) {
                bw.write("4");
                return;
            }
            int[][] array = new int[n + 1][n + 1];

            for (int i = 0; i <= n; i++) {
                array[i][0] = 1;
                array[0][i] = 1;
            }
            for (int sum = 2; sum <= n; sum++) {
                for (int r = 1; r < sum; r++) {
                    int c = sum - r;
                    array[r][c] = array[r - 1][c] + array[r][c - 1];
                }
            }
            int answer= 0;
            for(int i = 0; i <= n; i++) {
                answer += array[i][n-i];
            }
            bw.write(String.valueOf(answer));
        }
    }
}