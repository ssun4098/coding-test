import java.util.*;

class Solution {

    Set<Integer> set = new HashSet<>();
    boolean[] visited;

    public int solution(String numbers) {
        
        visited = new boolean[numbers.length()];
        
        dfs("", numbers);
        
        int count = 0;
        
        for(int num : set) {
            if(isPrime(num)) {
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(String current, String numbers) {
        
        if(!current.equals("")) {
            set.add(Integer.parseInt(current));
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            
            if(visited[i]) continue;
            
            visited[i] = true;
            
            dfs(current + numbers.charAt(i), numbers);
            
            visited[i] = false;
        }
    }
    
    private boolean isPrime(int num) {
        
        if(num < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}