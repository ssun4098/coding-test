class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int max = Integer.max(a, b);
        int min = Integer.min(a, b);
        for(int i = min; i <= max; i++) {
            answer += i;
        }
        
        return answer;
    }
}