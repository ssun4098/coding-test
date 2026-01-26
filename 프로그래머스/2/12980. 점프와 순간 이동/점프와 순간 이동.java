import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while(n > 0) {
            if(n % 2 == 1) {
                answer++;
                n -= 1;
            }
            n /= 2;
        }
        return answer;
    }
}
// dp[1] = 1
// dp[2] = 1 * 2
// dp[3] = 1 * 2 + 1
// dp[4] = (1+1) * 2