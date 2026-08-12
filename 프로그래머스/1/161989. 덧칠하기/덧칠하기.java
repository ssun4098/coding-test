class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int before = section[0];

        for (int i = 1; i < section.length; i++) {
            if (section[i] - before >= m) {
                answer++;
                before = section[i];
            }
        }

        return answer;
    }
}