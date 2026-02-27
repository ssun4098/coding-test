import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Set<String> set = new LinkedHashSet<>();
        for (String ori : cities) {

            if (cacheSize == 0) {
                answer += 5;
                continue;
            }

            String city = ori.toUpperCase();

            if (set.remove(city)) {
                set.add(city);
                answer += 1;
                continue;
            }

            if (set.size() >= cacheSize) {
                set.remove(set.iterator().next());
            }

            set.add(city);
            answer += 5;
        }
        return answer;
    }
}