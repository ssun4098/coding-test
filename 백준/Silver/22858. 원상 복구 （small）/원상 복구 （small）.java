import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            StringTokenizer first = new StringTokenizer(br.readLine(), " ");
            StringTokenizer second = new StringTokenizer(br.readLine(), " ");
            StringTokenizer third = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(first.nextToken());
            int k = Integer.parseInt(first.nextToken());
            int[] s = new int[n];
            int[] d = new int[n];

            for(int i = 0; i < n; i++) {
                s[i] = Integer.parseInt(second.nextToken());
                d[i] = Integer.parseInt(third.nextToken());

            }


            for(int i = 0; i < k; i++) {
                int[] copy = Arrays.copyOf(s, n);

                for(int j = 0; j < n; j++) {
                    s[d[j] - 1] = copy[j];
                }
            }
            System.out.println(Arrays.stream(s).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}