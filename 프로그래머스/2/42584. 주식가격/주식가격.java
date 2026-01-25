import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Node> q = new ArrayDeque<>();
        Arrays.fill(answer, 1);
        answer[prices.length - 1] = 0;
        q.add(new Node(0, prices[0]));
        
        for(int i = 1; i < prices.length; i++) {
            while(!q.isEmpty()) {
                Node last = q.peekLast();
                if(last.getN() <= prices[i]) {
                    break;
                }
                q.pollLast();
                answer[last.getI()] = i - last.getI();
            }
            q.add(new Node(i, prices[i]));
        }
        while(!q.isEmpty()) {
            Node last = q.poll();
            answer[last.getI()] = prices.length - last.getI() - 1;
        }
        return answer;
    }
    
    public class Node {
        private int i;
        private int n;
        
        public Node(int i, int n) {
            this.i = i;
            this.n = n;
        }
        
        public int getI() {
            return i;
        }
        
        public int getN() {
            return n;
        }
    }
}

// 2, 3, 1, 1, 2, 4, 4