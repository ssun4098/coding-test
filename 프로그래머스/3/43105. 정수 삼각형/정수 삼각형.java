class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];
        int answer = Integer.MIN_VALUE;
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                if(j == 0) {
                    dp[i][j] = triangle[i][0] + dp[i - 1][0];
                } else if(j == triangle[i].length - 1) {
                    dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }
        
        return answer == Integer.MIN_VALUE ? triangle[0][0] : answer;
    }
}

// 0 = 0
// 1 = 0 or 1
// 2 = 1 or 2
// n = n