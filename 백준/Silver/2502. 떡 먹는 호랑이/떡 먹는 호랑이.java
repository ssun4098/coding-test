import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            for (int a = 1; a <= k - 1; a++) {
                for (int b = a; b <= k - 1; b++) {
                    int result = check(a, b, d);
                    if (result == k) {
                        System.out.println(a);
                        System.out.println(b);
                        return;
                    }
                }
            }

        }
    }

    public static int check(int a, int b, int d) {
        int[] array = new int[d];
        array[0] = a;
        array[1] = b;
        for (int i = 2; i < d; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[d - 1];
    }
}