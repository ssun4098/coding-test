import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(br.readLine()));
            }
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (int num : list) {
                sb.append(num).append('\n');
            }
            bw.write(sb.toString());
        }
    }
}