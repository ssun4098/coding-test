import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            List<Integer>[] array = new ArrayList[n];
            //int[][] values = new int[n][n];
            int[] visited = new int[n];
            Arrays.fill(visited, -1);

            for (int i = 0; i < array.length; i++) {
                array[i] = new ArrayList<>();
            }


            for(int i = 0; i < m; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(stringTokenizer.nextToken()) - 1;
                int b = Integer.parseInt(stringTokenizer.nextToken()) - 1;
                array[a].add(b);
                array[b].add(a);
            }

            List<Integer> answer = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++) {
                Deque<Integer> deque = new ArrayDeque<>();
                deque.addAll(array[i]);
                int depth = 0;
                int total = 0;
                while(!deque.isEmpty()) {
                    int size = deque.size();
                    depth++;
                    for(int d = 0; d < size; d++) {
                        int node = deque.poll();
                        if(visited[node] != i) {
                            total += depth;
                            visited[node]= i;
                            deque.addAll(array[node]);
                        }
                    }
                }
                if(min > total) {
                    min = total;
                    answer = new ArrayList<>();
                    answer.add(i + 1);
                } else if(min == total) {
                    answer.add(i + 1);
                }
            }
            Collections.sort(answer);
            bw.write(String.valueOf(answer.get(0)));
        }
    }
}