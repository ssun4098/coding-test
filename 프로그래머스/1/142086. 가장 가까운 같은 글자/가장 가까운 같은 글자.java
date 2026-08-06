import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int[] answer = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                int before = map.get(c);
                answer[i] = i - before;
                } else {
                answer[i] = -1;
            }
            map.put(c, i);
        }
        
        
        return answer;
    }
}