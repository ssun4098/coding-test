import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int[] box = new int[m];
        int boxIndex = 0;
        Arrays.sort(score);
        
        for(int i = score.length - 1; i >= 0; i--) {
            box[boxIndex++] = score[i];
            if(boxIndex == m) {
                answer += box[m-1] * m;
                boxIndex = 0;
                box = new int[m];
            }
        }
        
        return answer;
    }
}