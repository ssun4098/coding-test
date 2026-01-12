import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
            String[] s = br.readLine().split(" ");
            int a =  Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            int d =  Integer.parseInt(s[3]);
            int e = Integer.parseInt(s[4]);
            int f = Integer.parseInt(s[5]);

            outer:
            for(int i = -999; i <= 999; i++) {
                for(int j = -999; j <= 999; j++) {
                    if((a * i + b * j) == c && (d * i + e * j) == f) {
                        bw.write(i + " " + j);
                        break outer;
                    }
                }
            }
        }
    }
}