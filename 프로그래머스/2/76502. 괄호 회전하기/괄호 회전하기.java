import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            Deque<String> deque = new ArrayDeque<>(List.of(s.split("")));
            
            // 회전
            for(int j = 0; j <= i; j++) {
                deque.addLast(deque.pollFirst());
            }
            
            Deque<String> deque2 = new ArrayDeque<>();
            deque2.add(deque.poll());
            boolean flag = true;
            
            while(!deque.isEmpty()) {
                String end = deque.poll();
                if(deque2.isEmpty()) {
                    deque2.add(end);
                    continue;
                }
                
                String start = deque2.peekLast();
                
                if(start.equals("[") && end.equals("]")) {
                    deque2.pollLast();
                    continue;
                }
                
                if(start.equals("(") && end.equals(")")) {
                    deque2.pollLast();
                    continue;
                }
                
                if(start.equals("{") && end.equals("}")) {
                    deque2.pollLast();
                    continue;
                }
                deque2.add(end);
            }
            if(deque2.isEmpty()) {
                answer++;
            }
        }
    
        return answer;
    }
}