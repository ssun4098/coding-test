import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[y + 1];

        q.add(x);
        visited[x] = true;

        int answer = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int now = q.poll();

                if (now == y) {
                    return answer;
                }

                int res1 = now + n;
                int res2 = now * 2;
                int res3 = now * 3;

                if (res1 <= y && !visited[res1]) {
                    visited[res1] = true;
                    q.add(res1);
                }

                if (res2 <= y && !visited[res2]) {
                    visited[res2] = true;
                    q.add(res2);
                }

                if (res3 <= y && !visited[res3]) {
                    visited[res3] = true;
                    q.add(res3);
                }
            }

            answer++;
        }

        return -1;
    }
}