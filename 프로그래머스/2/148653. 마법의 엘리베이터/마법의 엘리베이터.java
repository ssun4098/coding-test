class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0) {
            int mod = storey % 10;
            if(mod < 5) {
                answer += mod;
                storey -= mod;
            } else if(mod > 5) {
                answer += 10 - mod;
                storey += 10 - mod;
            } else {
                int storey2 = storey / 10;
                int storey3 = storey2 % 10;
                if(storey3 < 5) {
                    answer += mod;
                    storey -= mod;
                } else {
                    answer += 10 - mod;
                    storey += 10 - mod;
                }
            }
            storey = storey / 10;
        }
        return answer;
    }
}
