import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        
        for(String key: keymap) {
            for(int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if(map.containsKey(c)) {
                    int value = map.get(c);
                    map.put(c, Math.min(value, i+1));
                    continue;
                }
                map.put(c, i+1);
            }
        }
        
        for(int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int count = 0;
            for(int j = 0; j < target.length(); j++) {
                char c = target.charAt(j);
                if(!map.containsKey(c)) {
                    answer[i] = -1;
                    break;
                }
                count += map.get(c);
            }
            if(answer[i] != -1) {
                answer[i] = count;
            }
        }
        
        return answer;
    }
}