class Solution {
    public long solution(int n) {
        long answer = 0;
        int[] array = new int[n+2];
        array[1] = 1;
        array[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            array[i] = (array[i-1] + array[i-2]) % 1234567;
        }
        
        return array[n];
    }
}