class Solution {

    private static final char[] WORDS = {'A','E','I','O','U'};
    private int count = -1;
    private int answer;

    public int solution(String word) {
        dfs("", word);
        return answer;
    }

    private void dfs(String current, String target) {

        if(current.length() > 5) {
            return;
        }

        count++;

        if(current.equals(target)) {
            answer = count;
            return;
        }

        for(char c : WORDS) {
            dfs(current + c, target);

            // 찾았으면 더 탐색 안함
            if(answer != 0) {
                return;
            }
        }
    }
}