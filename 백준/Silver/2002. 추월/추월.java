import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> enterOrder = new HashMap<>();

        for (int i = 0; i < n; i++) {
            enterOrder.put(br.readLine(), i);
        }

        boolean[] exited = new boolean[n];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int current = enterOrder.get(br.readLine());

            for (int j = 0; j < current; j++) {
                if (!exited[j]) {
                    answer++;
                    break;
                }
            }

            exited[current] = true;
        }

        System.out.println(answer);
    }
}
