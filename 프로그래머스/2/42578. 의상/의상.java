import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1;
        
        for(int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            String clothe = clothes[i][0];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        for(int v: map.values()) {
            answer *= v + 1;
        }
        
        return answer - 1;
    }
}