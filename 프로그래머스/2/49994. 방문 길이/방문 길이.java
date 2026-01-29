class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int x = 5, y = 5; // 시작점 (0,0)을 배열 중앙으로
        
        boolean[][][][] visited = new boolean[11][11][11][11];
        
        for (char c : dirs.toCharArray()) {
            int nx = x;
            int ny = y;
            
            if (c == 'U') ny++;
            else if (c == 'D') ny--;
            else if (c == 'R') nx++;
            else if (c == 'L') nx--;
            
            // 범위 체크
            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;
            
            // 길 방문 체크 (양방향)
            if (!visited[x][y][nx][ny]) {
                visited[x][y][nx][ny] = true;
                visited[nx][ny][x][y] = true;
                answer++;
            }
            
            x = nx;
            y = ny;
        }
        
        return answer;
    }
}