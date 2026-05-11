import java.util.*;

class Solution {
    private int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] cost, int[][] hint) {
        dfs(cost, hint, 0, 0, new int[cost.length]);
        return answer;
    }

    private void dfs(
        int[][] cost,
        int[][] hint,
        int depth,
        int hintCost,
        int[] levels
    ) {
        if(depth == hint.length) {
            int total = hintCost;
            for(int i = 0; i < cost.length; i++) {
                int level = levels[i];
                level = Math.min(level, cost[i].length - 1);
                total += cost[i][level];
            }
            answer = Math.min(answer, total);
            return;
        }
        dfs(cost, hint, depth + 1, hintCost, levels);
        
        List<Integer> changed = new ArrayList<>();
        
        for(int i = 1; i < hint[depth].length; i++) {

            int problem = hint[depth][i] - 1;

            if(problem < 0 || problem >= levels.length) {
                continue;
            }

            levels[problem]++;
            changed.add(problem);
        }

        dfs(
            cost,
            hint,
            depth + 1,
            hintCost + hint[depth][0],
            levels
        );
        for(int problem : changed) {
            levels[problem]--;
        }
    }
}