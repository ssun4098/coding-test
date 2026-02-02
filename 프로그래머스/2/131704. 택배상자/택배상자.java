import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int cursor = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i <= order.length; i++) {
            deque.add(i);
            while(!deque.isEmpty()) {
                int peek = deque.peekLast();
                if(peek == order[cursor]) {
                    deque.pollLast();
                    cursor++;
                    answer++;
                } else {
                    break;
                }
            }
        }

        while(!deque.isEmpty()) {
            int pop = deque.pollLast();
            if(pop == order[cursor]) {
                cursor++;
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}
