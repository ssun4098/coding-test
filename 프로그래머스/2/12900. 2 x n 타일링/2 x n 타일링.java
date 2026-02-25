import java.util.*;

class Solution {
    public int solution(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        int[] array = new int[n+1];
        array[1] = 1;
        array[2] = 2;
        for(int i = 3; i <= n; i++) {
            array[i] = (array[i-1] % 1000000007 + array[i-2] % 1000000007) % 1000000007;
        }
        return array[n];
    }
}