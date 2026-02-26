import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int a = 0; a < t; a++) {
            int n = Integer.parseInt(br.readLine());
            solution("1", 2, n);

            Collections.sort(list);

            for(String s: list) {
                bw.write(s);
                bw.newLine();
            }
            list.clear();
            bw.newLine();
        }
        bw.flush();
    }

    public static void solution(String s, int n, int max) {
        if (n > max) {
            if (calculate(s) == 0) {
                //System.out.println(s);
                list.add(s);
            }
            return;
        }
        int next = n + 1;
        solution(s+"+"+n, next, max);
        solution(s+"-"+n, next, max);
        solution(s+" "+n, next, max);
    }

    public static int calculate(String ori) {
        String s = ori.replace(" ", "");   // 공백 제거

        int sum = 0;
        int num = 0;
        char sign = '+';  // 첫 숫자는 무조건 +

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (!Character.isDigit(c) || i == s.length() - 1) {
                if (sign == '+') {
                    sum += num;
                } else if (sign == '-') {
                    sum -= num;
                }

                sign = c;
                num = 0;
            }
        }

        return sum;
    }
}
