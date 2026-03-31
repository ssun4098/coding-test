import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Deque<Container> containers = new ArrayDeque<>();
            Deque<Container> last = new ArrayDeque<>();
            
            int[] pCount = new int[m + 1];

            int answer = 0;
            for(int i = 0; i < n; i++) {
                StringTokenizer containerMeta = new StringTokenizer(br.readLine(), " ");
                int p = Integer.parseInt(containerMeta.nextToken());
                int w = Integer.parseInt(containerMeta.nextToken());
                containers.add(new Container(w, p));
                pCount[p]++;
            }
            
            int currentTargetP = m;

            while(!containers.isEmpty()) {
                
                while(currentTargetP > 0 && pCount[currentTargetP] == 0) {
                    currentTargetP--;
                }

                Container header = containers.poll();
                
                if(header.getP() != currentTargetP) {
                    answer += header.getW();
                    containers.add(header);
                    continue;
                }
                
                pCount[header.getP()]--;
                answer += header.getW();

                if(last.isEmpty()) {
                    last.add(header);
                    continue;
                }

                Deque<Container> temp = new ArrayDeque<>();
                
                while(!last.isEmpty()) {
                    Container top = last.peekLast();

                    if(top.getP() != header.getP()) break;
                    if(top.getW() >= header.getW()) break;

                    Container pop = last.pollLast();
                    answer += pop.getW();
                    temp.addFirst(pop);
                }

                last.addLast(header);

                while(!temp.isEmpty()) {
                    Container putBack = temp.pollFirst();
                    answer += putBack.getW();
                    last.addLast(putBack);
                }
            }

            System.out.println(answer);
        }
    }

    public static class Container {
        private int w; // 무게
        private int p; // 우선순위

        public Container(int w, int p) {
            this.w = w;
            this.p = p;
        }

        public int getW() { return w; }
        public int getP() { return p; }
    }
}