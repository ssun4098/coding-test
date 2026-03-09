import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer firstInput = new StringTokenizer(br.readLine(), " ");
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = Integer.parseInt(firstInput.nextToken()); // 도시의 갯수
        int m = Integer.parseInt(firstInput.nextToken()); // 도로의 갯수
        int k = Integer.parseInt(firstInput.nextToken()); // 거리 정보
        int x = Integer.parseInt(firstInput.nextToken()); // 출발 도시

        for(int i = 0; i < m; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(input.nextToken());
            int end = Integer.parseInt(input.nextToken());

            List<Integer> list1 = map.getOrDefault(start, new ArrayList<>());
            list1.add(end);
            map.put(start, list1);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        visited[x] = true;
        List<Integer> answer = new ArrayList<>();
        int counter = 0;
        deque.add(x);
        while(!deque.isEmpty()) {
            if(counter == k) {
                answer.addAll(deque);
                break;
            }
            int size = deque.size();
            for(int i = 0; i < size; i++) {
                int v = deque.poll();
                List<Integer> list = map.getOrDefault(v, new ArrayList<>());
                for(int aa: list) {
                    if(!visited[aa]) {
                        visited[aa] = true;
                        deque.add(aa);
                    }
                }
            }
            counter++;
        }
        if(answer.isEmpty()) {
            bw.write("-1");
        } else {
            Collections.sort(answer);
            for(int i: answer) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }
        bw.flush();
    }
}