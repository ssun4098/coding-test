class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;

        while(n >= 0) {
            answer++;
            
            int a1 = 0;
            int b1 = 0;
            
            if(a % 2 != 0) {
                a1 = a / 2 + 1;
            } else {
                a1 = a / 2;
            }
            
            if(b % 2 != 0) {
                b1 = b / 2 + 1;
            } else {
                b1 = b / 2;
            }
            
            if(a1 == b1) {
                break;
            }
            
            a = a1;
            b = b1;
            n /= 2;
        }

        return answer;
    }
}