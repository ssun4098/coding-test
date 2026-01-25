class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int w = yellow; w > 0; w--) {
            if(yellow % w != 0) {
                continue;
            }
            int h = yellow / w;
            if(w * 2 + h * 2 + 4 == brown) {
                answer[0] = w + 2;
                answer[1] = h + 2;
                break;
            }
        }
        return answer;
    }
}