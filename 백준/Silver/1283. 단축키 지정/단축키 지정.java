import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            int n = Integer.parseInt(br.readLine());
            String[] array = new String[n];
            for(int i = 0; i < n; i++) {
                array[i] = br.readLine();
            }

            Set<Character> set = new HashSet<>();

            for(String s: array) {
                String original = s;
                String upper = s.toUpperCase();

                String[] tokens = upper.split(" ");
                boolean flag = false;
                int cursor = 0;
                int pos = 0;

                for (String token : tokens) {
                    char first = token.charAt(0);

                    if (!set.contains(first)) {
                        flag = true;
                        set.add(first);
                        cursor = pos;
                        break;
                    }

                    pos += token.length() + 1; // 단어 길이 + 공백
                }

                if(flag) {
                    printOption(original, cursor);
                    continue;
                }

                char[] chars = upper.toCharArray();
                for(int i = 0; i < chars.length; i++) {
                    if(chars[i] == ' ') continue;

                    if(!set.contains(chars[i])) {
                        flag = true;
                        cursor = i;
                        set.add(chars[i]);
                        break;
                    }
                }

                if(flag) {
                    printOption(original, cursor);
                    continue;
                }

                System.out.println(original);
            }
        }
    }

    public static void printOption(String s, int i) {
        StringBuilder sb = new StringBuilder(s);

        sb.insert(i, '[');
        sb.insert(i + 2, ']');

        System.out.println(sb);
    }
}