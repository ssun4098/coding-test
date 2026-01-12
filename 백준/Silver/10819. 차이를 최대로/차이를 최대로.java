import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    private static int answer = Integer.MIN_VALUE;
    private static boolean[] visited;
    private static int[] array;
    private static Deque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
            int n = Integer.parseInt(br.readLine());
            array = new int[n + 1];
            String[] ss = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                array[i] = Integer.parseInt(ss[i-1]);
            }
            for(int i = 1; i <= n; i++){
                visited = new boolean[n + 1];
                find(i);
            }
            bw.write(String.valueOf(answer));
        }
    }

    private static void find(int n) {
        if (stack.size() == array.length - 1) {
            List<Integer> list = new ArrayList<>(stack);
            int sum = 0;

            for (int i = 0; i < list.size() - 1; i++) {
                sum += Math.abs(
                        array[list.get(i)] - array[list.get(i + 1)]
                );
            }

            answer = Math.max(answer, sum);
            return;
        }
        if(visited[n]){
            return;
        }
        visited[n] = true;
        stack.push(n);
        for(int i = 1; i < array.length; i++) {
            find(i);
        }
        visited[n] = false;
        stack.pop();
    }
}