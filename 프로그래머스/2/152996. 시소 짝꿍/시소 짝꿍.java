import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Long> map = new HashMap<>();
        
        // 각 무게의 개수를 카운트
        for (int weight : weights) {
            map.put(weight, map.getOrDefault(weight, 0L) + 1);
        }
        
        for (int weight : map.keySet()) {
            long count = map.get(weight);
            
            if (count > 1) {
                answer += count * (count - 1) / 2;
            }
            
            if (weight * 2 % 3 == 0) {
                int other = weight * 2 / 3;
                if (map.containsKey(other)) {
                    answer += count * map.get(other);
                }
            }
            
            if (weight % 2 == 0) {
                int other = weight / 2;
                if (map.containsKey(other)) {
                    answer += count * map.get(other);
                }
            }
            
            if (weight * 3 % 4 == 0) {
                int other = weight * 3 / 4;
                if (map.containsKey(other)) {
                    answer += count * map.get(other);
                }
            }
        }
        
        return answer;
    }
}