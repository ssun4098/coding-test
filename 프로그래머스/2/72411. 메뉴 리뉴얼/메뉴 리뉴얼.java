import java.util.*;

class Solution {
    private Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] courses) {
        List<String> answer = new ArrayList<>();
        
        for(int course : courses) {
            map = new HashMap<>();
            
            for(String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                comb(arr, course, 0, new StringBuilder());
            }
            
            int max = 0;
            
            for(int value : map.values()) {
                if(value >= 2) {
                    max = Math.max(max, value);
                }
            }
            
            for(Map.Entry<String,Integer> entry : map.entrySet()) {
                if(entry.getValue() == max && max >= 2) {
                    answer.add(entry.getKey());
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    
    
    private void comb(char[] arr, int course, int idx, StringBuilder sb) {
        
        if(sb.length() == course) {
            String key = sb.toString();
            map.put(key, map.getOrDefault(key,0) + 1);
            return;
        }
        
        for(int i = idx; i < arr.length; i++) {
            sb.append(arr[i]);
            comb(arr, course, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}