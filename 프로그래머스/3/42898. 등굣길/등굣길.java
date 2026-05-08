import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] array = new int[m + 1][n + 1];
        array[1][1] = 1;
        
        for(int i = 0; i < puddles.length; i++) {
            array[puddles[i][0]][puddles[i][1]] = -1;
        }
        
        for(int i = 1; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(i == 1 && j == 1) {
                    continue;
                }
                if(array[i][j] == -1) {
                    array[i][j] = 0;
                    continue;
                }
                int up = array[i-1][j] == -1 ? 0 : array[i-1][j];
                int left = array[i][j-1] == -1 ? 0 : array[i][j-1];
                array[i][j] = (up + left) % 1000000007;
            }
        }
        
        return array[m][n];
    }
}