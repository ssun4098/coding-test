import java.util.*;
import java.lang.StringBuilder; 

class Solution {
    public int[] solution(String s) {
        Set<Integer> answer = new LinkedHashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        
        // 문자열 가공 시작 {} 제거
        s = s.substring(1, s.length() - 1);
        int maxSize = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '{') {
                List<Integer> tuple = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                for(int j = i+1; j < s.length(); j++) {
                    char c2 = s.charAt(j);
                    if(c2 >= '0' && c2 <= '9') {
                        sb.append(c2);
                    }
                    if(c2 == '}') {
                        tuple.add(Integer.parseInt(sb.toString()));
                        sb.setLength(0);
                        i = j;
                        break;
                    }
                    else if(c2 == ',') {
                        tuple.add(Integer.parseInt(sb.toString()));
                        sb.setLength(0);
                        continue;
                    }
                    
                }
                maxSize = Math.max(maxSize, tuple.size());
                list.add(tuple);
            }
        }
        for(int i = 1; i <= maxSize; i++) {
            for(List<Integer> tuple: list) {
                if(tuple.size() == i) {
                    answer.addAll(tuple);
                }
            }
        }
        return answer.stream()
               .mapToInt(Integer::intValue)
               .toArray();
    }
}