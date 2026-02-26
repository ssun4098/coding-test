import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;
        int counter = -1;
        boolean[] visited = new boolean[words.length];
        Deque<String> deque = new ArrayDeque<>();
        deque.add(begin);
        while(!deque.isEmpty()) {
            counter++;
            for(int i = 0; i < deque.size(); i++) {
                String now = deque.poll();
                if(now.equals(target)) {
                    answer = Math.min(answer, counter);
                }
                for(int j = 0; j < words.length; j++) {
                    if(!visited[j]) {
                        int compareResult = compare(now, words[j]);
                        if(compareResult == 1) {
                            deque.add(words[j]);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    public int compare(String a, String b) {
        int answer = 0;
        
        // 모든 단어의 길이는 같다.
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                answer++;
            }
        }
        return answer;
    }
}