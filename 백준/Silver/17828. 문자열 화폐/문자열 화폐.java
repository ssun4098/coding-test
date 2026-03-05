import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        long n = Long.parseLong(stringTokenizer.nextToken());
        long x = Long.parseLong(stringTokenizer.nextToken());

        if(x < n || x > 26 * n) {
            bw.write("!");
            bw.flush();
            return;
        }

        long z = x / 26;
        long z3 = x % 26;

        if(z3 == 0) { z--; z3 = 26; }

        while(z3 < n - z - 1) {
            z--;
            z3 += 26;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < z; i++) {
            stringBuilder.append('Z');
        }

        StringBuilder stringBuilder1 = new StringBuilder();

        for(int i = 0; i < n - z - 1; i++) {
            stringBuilder1.append('A');
            z3--;
        }

        if(z3 > 0 && z3 <= 26) {
            stringBuilder1.append((char)('A' + z3 - 1));
        }

        stringBuilder1.append(stringBuilder);

        bw.write(stringBuilder1.toString());
        bw.flush();
    }
}