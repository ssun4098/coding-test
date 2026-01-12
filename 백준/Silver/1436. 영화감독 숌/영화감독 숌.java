import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
            int n = Integer.parseInt(br.readLine());

            int counter = 0;
            int i = 665;
            while (true) {
                if(String.valueOf(i).contains("666")) {
                    counter++;
                }
                if(counter == n) {
                    bw.write(String.valueOf(i));
                    break;
                }
                i++;
            }
        }
    }
}