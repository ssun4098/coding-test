class Solution {
    public int solution(String s) {
        int answer = 0;
        String first = "";
        int firstCount = 0;
        int other = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(first.isEmpty()) {
                first = String.valueOf(c);
                firstCount = 1;
                continue;
            }
            if(first.equals(String.valueOf(c))) {
                firstCount++;
                continue;
            }
            other++;
            if(firstCount == other) {
                answer++;
                first = "";
                firstCount = 0;
                other = 0;
            }
        }
        if(!first.isEmpty()) {
            answer++;
        }
        
        return answer;
    }
}