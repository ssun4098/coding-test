import java.util.*;

import java.util.*;

class Solution {
    private Map<String, Integer> map = new HashMap<>();

    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();

        init();

        while(!msg.isEmpty()) {
            int end = 1;

            // 사전에 존재하는 가장 긴 문자열 찾기
            while(end <= msg.length() && map.containsKey(msg.substring(0, end))) {
                end++;
            }

            // 마지막으로 존재했던 문자열
            String w = msg.substring(0, end - 1);
            answer.add(map.get(w));

            // 다음 문자열 사전에 추가
            if(end <= msg.length()) {
                String next = msg.substring(0, end);
                map.put(next, map.size() + 1);
            }

            // 처리한 부분 제거
            msg = msg.substring(end - 1);
        }

        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private void init() {
        for(char c = 'A'; c <= 'Z'; c++) {
            map.put(String.valueOf(c), c - 'A' + 1);
        }
    }
}