import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for(String calling: callings) {
            int i = map.get(calling); // 부른 사람의 순서를 가져옴
            String temp = players[i-1]; // 앞사람
            
            players[i-1] = calling;
            players[i] = temp;
            
            map.put(calling, i-1);
            map.put(temp, i);
            
        }
        
        
        return players;
    }
}