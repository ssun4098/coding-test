import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int f = Integer.parseInt(stringTokenizer.nextToken());
            int s = Integer.parseInt(stringTokenizer.nextToken());
            int g = Integer.parseInt(stringTokenizer.nextToken());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int d = Integer.parseInt(stringTokenizer.nextToken());

            boolean[] visited = new boolean[f + 1];
            Deque<Integer> deque = new ArrayDeque<>();
            int step = 0;
            boolean isCan = false;
            deque.add(s);

            outer:
            while(!deque.isEmpty()) {
                int size = deque.size();
                for(int i = 0; i < size; i++) {
                    int now = deque.poll();

                    if(now == g) {
                        isCan = true;
                        break outer;
                    }

                    int up = now + u;
                    int down = now - d;

                    if(down > 0 && !visited[down]) {
                        visited[down] = true;
                        deque.add(down);
                    }

                    if(up <= f && !visited[up]) {
                        visited[up] = true;
                        deque.add(up);
                    }
                }
                step++;
            }
            if(isCan) {
                bw.write(String.valueOf(step));
            } else {
                bw.write("use the stairs");
            }
        }
    }
}