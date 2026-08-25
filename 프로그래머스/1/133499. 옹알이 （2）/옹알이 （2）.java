class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        String[] words = {"aya", "ye", "woo", "ma"};

        for (String b : babbling) {
            String prev = "";

            while (!b.isEmpty()) {
                boolean found = false;

                for (String word : words) {
                    if (b.startsWith(word) && !word.equals(prev)) {
                        b = b.substring(word.length());
                        prev = word;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    break;
                }
            }

            if (b.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}