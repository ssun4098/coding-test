class Solution {
    private int answer = 0;
    private int counter = -1;
    private String[] array = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        bfs("", word);
        return answer;
    }
    
    public void bfs(String now, String word) {
        if(now.length() > 5) {
            return;
        }
        counter++;
        if(now.equals(word)) {
            answer = counter;
            return;
        }
        
        for(String s: array) {
            bfs(now + s, word);
        }
    }
}