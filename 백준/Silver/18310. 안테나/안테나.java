import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());
            int[] homes = new int[n];
            int answer = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < n; i++) {
                homes[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(homes);

            System.out.println(homes[(n-1)/2]);
            
        }
    }
}