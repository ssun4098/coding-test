import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Set<String> keywords = new HashSet<>();
            for (int i = 0; i < n; i++) {
                keywords.add(br.readLine());
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < m; i++) {
                String[] parts = br.readLine().split(",");
                
                for (String part : parts) {
                    keywords.remove(part);
                }
                sb.append(keywords.size()).append('\n');
            }

            System.out.print(sb);
        }
    }
}