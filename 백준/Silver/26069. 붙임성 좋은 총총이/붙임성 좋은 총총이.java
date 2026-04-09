import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final String chongChong = "ChongChong";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            Set<String> set = new HashSet<>();
            set.add(chongChong);
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String first = st.nextToken();
                String second = st.nextToken();
                if(set.contains(first) || set.contains(second)) {
                    set.add(first);
                    set.add(second);
                }
            }
            System.out.println(set.size());
        }
    }
}