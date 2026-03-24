import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer first = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(first.nextToken());
        int m = Integer.parseInt(first.nextToken());
        int answer = 0;
        String[] prefixs = new String[n];
        String[] words = new String[m];

        for(int i = 0; i < n; i++) {
            prefixs[i] = br.readLine();
        }

        for(int i = 0; i < m; i++) {
            words[i] = br.readLine();
        }


        TreeSet<String> set = new TreeSet<>(Arrays.asList(prefixs));

        for(String word : words) {
            String candidate = set.ceiling(word);

            if(candidate != null && candidate.startsWith(word)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
