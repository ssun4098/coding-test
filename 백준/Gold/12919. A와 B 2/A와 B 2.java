import java.io.*;

public class Main {

    private static int answer = 0;
    private static String word;


    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            word = br.readLine();

            solve(br.readLine());
            bw.write(String.valueOf(answer));
        }
    }

    private static void solve(String s) {
        if(word.equals(s)) {
            answer = 1;
            return;
        }
        if(word.length() >= s.length()) {
            return;
        }
        if(s.charAt(s.length()-1) == 'A') {
            solve(s.substring(0, s.length()-1));
        }
        if(s.charAt(0) == 'B') {
            String newS = new StringBuilder(s).reverse().toString();
            solve(newS.substring(0, newS.length()-1));
        }
    }

}