import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int t = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < t; i++) {
                list.add(Integer.parseInt(br.readLine()));
            }
            Collections.sort(list);

            int answer = -1;
            for(int i = list.size() - 1; i >= 2; i--) {
                if(list.get(i) < list.get(i - 1) + list.get(i - 2)) {
                    answer = Math.max(answer, list.get(i) + list.get(i - 1) + list.get(i - 2));
                }
            }
            bw.write(String.valueOf(answer));
        }
    }
}
