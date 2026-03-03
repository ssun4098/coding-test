import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer firstInput = new StringTokenizer(br.readLine(), " ");
        StringTokenizer secondInput = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(firstInput.nextToken());
        int t = Integer.parseInt(firstInput.nextToken());
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        String hAndH = secondInput.nextToken();

        for(int i = 0; i < hAndH.length(); i++) {
            char c = hAndH.charAt(i);
            if(c == 'H') {
                continue;
            }
            int start = Math.max(i - t, 0);
            int end = Math.min(i + t, n - 1);

            for(int j = start; j <= end; j++) {
                char cursor = hAndH.charAt(j);
                if(cursor == 'P') {
                    continue;
                }
                if(!set.contains(j)) {
                    answer++;
                    set.add(j);
                    break;
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}