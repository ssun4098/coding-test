import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> bridge = new ArrayDeque<>();
        int answer = 0;
        int totalWeight = 0;
        int index = 0;

        // 다리를 길이 w로 초기화 (0으로 채움)
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }

        while (index < n) {
            answer++;
            totalWeight -= bridge.poll();
            
            if (totalWeight + trucks[index] <= l) {
                bridge.add(trucks[index]);
                totalWeight += trucks[index];
                index++;
            } else {
                bridge.add(0);
            }
        }

        
        answer += w;

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}