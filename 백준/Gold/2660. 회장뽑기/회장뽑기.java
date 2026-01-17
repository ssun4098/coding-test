import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            int n = Integer.parseInt(br.readLine());

            int[][] array = new int[n+1][n+1];
            int[] visited = new int[n+1];

            while(true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(x == -1 && y == -1) {
                    break;
                }
                array[x][y] = 1;
                array[y][x] = 1;
            }

            List<Integer> list = new ArrayList<>();
            int answer = Integer.MAX_VALUE;
            for(int i = 1; i <= n; i++) {
                Deque<Integer> deque = new ArrayDeque<>();
                deque.add(i);
                int point = 0;
                while(!deque.isEmpty()) {
                    int size = deque.size();
                    for(int j = 0; j < size; j++) {
                        int cur = deque.poll();
                        for(int k = 1; k <= n; k++) {
                            if(array[cur][k] == 1 && visited[k] != i && i != k) {
                                visited[k] = i;
                                deque.add(k);
                            }
                        }
                    }
                    if(!deque.isEmpty()) {
                        point++;
                    }
                }
                if(point < answer) {
                    answer = point;
                    list.clear();
                    list.add(i);
                } else if(point == answer) {
                    list.add(i);
                }
            }
            bw.write(answer + " " + list.size() + "\n");
            for (Integer integer : list) {
                bw.write(integer + " ");
            }

        }
    }
}