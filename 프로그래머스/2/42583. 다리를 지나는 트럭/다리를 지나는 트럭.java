import java.util.*;

class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        int answer = 0;
        int i = 0;
        int sumW = 0;
        int sumL = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int j = 0; j < bridgeLength; j++) {
            deque.add(-1);
            sumL++;
        }
        
        while(i < truckWeights.length) {
            int poll = deque.poll();
            sumL--;
            answer++;
            if(poll != -1) {
                sumW -= truckWeights[poll];
            }
            int w = truckWeights[i];
            if(sumL + 1 <= bridgeLength && sumW + w <= weight) {
                sumW += w;
                sumL++;
                deque.add(i);
                i++;
            } else {
                deque.add(-1);
                sumL++;
            }
        }
        while(!deque.isEmpty()) {
            answer++;
            deque.poll();
        }
        
        return answer;
    }
}