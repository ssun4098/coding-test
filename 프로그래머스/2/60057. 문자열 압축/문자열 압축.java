import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        if(s.length() == 1) {
            return 1;
        }
        
        // i는 나누는 단위
        for(int i = 1; i < s.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            String before = "";
            int count = 0;
            int j = 0;

            while(j+i <= s.length()) {
                String substring = s.substring(j, j+i);

                if(before.equals(substring)) {
                    count++;
                } else {
                    String word = "";
                    if(count >= 2) {
                        word += String.valueOf(count) + word;
                    }
                    sb.append(word).append(before);
                    before = substring;
                    count=1;
                }
                j += i;
            }
            String word = "";
            if(count >= 2) {
                word += String.valueOf(count) + word;
            }
            sb.append(word).append(before);
            sb.append(s, j, s.length());


            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}