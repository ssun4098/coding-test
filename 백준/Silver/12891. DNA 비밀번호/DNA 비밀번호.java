import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer firstInput = new StringTokenizer(br.readLine(), " ");
        StringTokenizer secondInput = new StringTokenizer(br.readLine());
        StringTokenizer thirdInput = new StringTokenizer(br.readLine(), " ");

        int s = Integer.parseInt(firstInput.nextToken());
        int p = Integer.parseInt(firstInput.nextToken());
        String dna = secondInput.nextToken();
        int[] acgt = new int[4];
        int[] cache = new int[4];
        int answer = 0;
        for(int i = 0; i < 4; i++) {
            acgt[i] = Integer.parseInt(thirdInput.nextToken());
        }
        int end = p;
        char[] chars = dna.toCharArray();

        for(int i = 0; i < p; i++) {
            char c = chars[i];
            add(cache, c);
        }

        while(end <= s) {
            boolean flag = true;
            for(int i = 0; i < 4; i++) {
                if(cache[i] < acgt[i]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                answer++;
            }
            if(end < s) {
                char remove = chars[end - p];
                char add = chars[end];
                remove(cache, remove);
                add(cache, add);
            }
            end++;
        }



        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static void add(int[] array, char c) {
        if(c == 'A') {
            array[0]++;
        }

        if(c == 'C') {
            array[1]++;
        }

        if(c == 'G') {
            array[2]++;
        }

        if(c == 'T') {
            array[3]++;
        }
    }

    private static void remove(int[] array, char c) {
        if(c == 'A') {
            array[0]--;
        }

        if(c == 'C') {
            array[1]--;
        }

        if(c == 'G') {
            array[2]--;
        }

        if(c == 'T') {
            array[3]--;
        }
    }
}