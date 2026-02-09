import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }
        
        for (int[] w : wires) {
            int a = w[0];
            int b = w[1];

            boolean[] visited = new boolean[n + 1];

        
            visited[b] = true;
            int count = dfs(a, visited, map);

            int diff = Math.abs(n - 2 * count);
            answer = Math.min(answer, diff);
        }
        
        return answer;
        }
    
        int dfs(int node, boolean[] visited, Map<Integer, List<Integer>> map) {
            visited[node] = true;
            int count = 1;

            for (int next : map.get(node)) {
                if (!visited[next]) {
                    count += dfs(next, visited, map);
                }
            }
            return count;
        }
}