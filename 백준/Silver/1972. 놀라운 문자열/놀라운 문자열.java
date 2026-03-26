import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            while(true) {
                String input  = br.readLine();
                if(input.equals("*")) {
                    return;
                }
                surprising(input);
            }
        }
    }

    public static void surprising(String s) {
        char[] chars = s.toCharArray();

        for(int d = 0; d < chars.length - 1; d++) {

            Set<String> set = new HashSet<>();

            for(int i = 0; i < chars.length - d - 1; i++) {

                String word = "" + chars[i] + chars[i + d + 1];

                if(!set.add(word)) {
                    System.out.println(s + " is NOT surprising.");
                    return;
                }
            }
        }

        System.out.println(s + " is surprising.");
    }
}