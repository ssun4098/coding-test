import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] array = new int[n];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(st1.nextToken());
            }

            Arrays.sort(array);
            solution(array, m, 0, new int[m], 0);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void solution(int[] array, int m, int depth, int[] selected, int start) {
        if(depth == m) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < m; i++) {
                sb.append(selected[i]);
                if(i < m - 1) sb.append(" ");
            }
            String result = sb.toString();
            if(!set.contains(result)) {
                System.out.println(result);
                set.add(result);
            }
            return;
        }

        for(int i = start; i < array.length; i++) {
            selected[depth] = array[i];
            solution(array, m, depth + 1, selected, i + 1);
        }
    }
}