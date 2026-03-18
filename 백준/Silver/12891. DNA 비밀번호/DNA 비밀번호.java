import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer firstInput = new StringTokenizer(br.readLine());
        String dna = br.readLine();
        StringTokenizer thirdInput = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(firstInput.nextToken());
        int p = Integer.parseInt(firstInput.nextToken());

        int[] acgt = new int[4];
        int[] cache = new int[4];

        for(int i = 0; i < 4; i++) {
            acgt[i] = Integer.parseInt(thirdInput.nextToken());
        }

        char[] chars = dna.toCharArray();
        int answer = 0;

        // 초기 윈도우
        for(int i = 0; i < p; i++) {
            add(cache, chars[i]);
        }

        for(int end = p; end <= s; end++) {

            if(isValid(cache, acgt)) {
                answer++;
            }

            if(end == s) break;

            remove(cache, chars[end - p]);
            add(cache, chars[end]);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static boolean isValid(int[] cache, int[] acgt) {
        for(int i = 0; i < 4; i++) {
            if(cache[i] < acgt[i]) {
                return false;
            }
        }
        return true;
    }

    private static void add(int[] array, char c) {
        array[index(c)]++;
    }

    private static void remove(int[] array, char c) {
        array[index(c)]--;
    }

    private static int index(char c) {
        if(c == 'A') return 0;
        if(c == 'C') return 1;
        if(c == 'G') return 2;
        return 3; // T
    }
}