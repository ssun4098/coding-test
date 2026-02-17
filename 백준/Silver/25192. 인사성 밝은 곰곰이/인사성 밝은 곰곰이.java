import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static String ENTER = "ENTER";
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int answer = 0;
            Set<String> set = new HashSet<>();
            for(int i = 0; i < n; i++) {
                String s = bufferedReader.readLine();
                if(ENTER.equals(s)) {
                    set.clear();
                    continue;
                }
                if(!set.contains(s)) {
                    answer++;
                }
                set.add(s);
            }
            bufferedWriter.write(String.valueOf(answer));
        }
    }
}