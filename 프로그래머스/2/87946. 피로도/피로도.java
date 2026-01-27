import java.util.*;

class Solution {
    boolean[] visited;
    int answer = 0;
    public int solution(int k, int[][] dungeons) {    
        for(int i = 0; i < dungeons.length; i++) {
            visited = new boolean[dungeons.length];
            recus(k, dungeons, i, 0);
        }
        
        return answer;
    }
    
public void recus(int k, int[][] dungeons, int now, int count) {
    if (k < dungeons[now][0]) {
        answer = Math.max(answer, count);
        return;
    }

    visited[now] = true;
    int newCount = count + 1;
    answer = Math.max(answer, newCount);

    for (int i = 0; i < dungeons.length; i++) {
        if (!visited[i]) {
            recus(k - dungeons[now][1], dungeons, i, newCount);
        }
    }

    visited[now] = false;
}
}