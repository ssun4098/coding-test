import java.util.*;

class Solution {
    private boolean[][] redVisited;
    private boolean[][] blueVisited;

    private final int[] dx = {0, 0, -1, 1};
    private final int[] dy = {-1, 1, 0, 0};

    private int answer = Integer.MAX_VALUE;

    public int solution(int[][] maze) {
        int redX = 0, redY = 0;
        int blueX = 0, blueY = 0;

        redVisited = new boolean[maze.length][maze[0].length];
        blueVisited = new boolean[maze.length][maze[0].length];

        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {
                if (maze[y][x] == 1) {
                    redX = x;
                    redY = y;
                } else if (maze[y][x] == 2) {
                    blueX = x;
                    blueY = y;
                }
            }
        }

        redVisited[redY][redX] = true;
        blueVisited[blueY][blueX] = true;

        dfs(maze, redX, redY, blueX, blueY, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private void dfs(
        int[][] maze,
        int redX,
        int redY,
        int blueX,
        int blueY,
        int depth
    ) {

        if (maze[redY][redX] == 3 &&
            maze[blueY][blueX] == 4) {
            answer = Math.min(answer, depth);
            return;
        }

        if (depth >= answer) {
            return;
        }

        for (int rDir = 0; rDir < 4; rDir++) {
            for (int bDir = 0; bDir < 4; bDir++) {

                int nextRedX;
                int nextRedY;

                int nextBlueX;
                int nextBlueY;

                boolean redArrived = maze[redY][redX] == 3;
                boolean blueArrived = maze[blueY][blueX] == 4;

                if (redArrived) {
                    nextRedX = redX;
                    nextRedY = redY;
                } else {
                    nextRedX = redX + dx[rDir];
                    nextRedY = redY + dy[rDir];
                }

                if (blueArrived) {
                    nextBlueX = blueX;
                    nextBlueY = blueY;
                } else {
                    nextBlueX = blueX + dx[bDir];
                    nextBlueY = blueY + dy[bDir];
                }

                // 범위 체크
                if (nextRedX < 0 || nextRedX >= maze[0].length ||
                    nextRedY < 0 || nextRedY >= maze.length) {
                    continue;
                }

                if (nextBlueX < 0 || nextBlueX >= maze[0].length ||
                    nextBlueY < 0 || nextBlueY >= maze.length) {
                    continue;
                }

                // 벽 체크
                if (maze[nextRedY][nextRedX] == 5) {
                    continue;
                }

                if (maze[nextBlueY][nextBlueX] == 5) {
                    continue;
                }

                // 방문 체크
                if (!redArrived &&
                    redVisited[nextRedY][nextRedX]) {
                    continue;
                }

                if (!blueArrived &&
                    blueVisited[nextBlueY][nextBlueX]) {
                    continue;
                }

                // 같은 칸
                if (nextRedX == nextBlueX &&
                    nextRedY == nextBlueY) {
                    continue;
                }

                // 자리 교환
                if (nextRedX == blueX &&
                    nextRedY == blueY &&
                    nextBlueX == redX &&
                    nextBlueY == redY) {
                    continue;
                }

                if (!redArrived) {
                    redVisited[nextRedY][nextRedX] = true;
                }

                if (!blueArrived) {
                    blueVisited[nextBlueY][nextBlueX] = true;
                }

                dfs(
                    maze,
                    nextRedX,
                    nextRedY,
                    nextBlueX,
                    nextBlueY,
                    depth + 1
                );

                if (!redArrived) {
                    redVisited[nextRedY][nextRedX] = false;
                }

                if (!blueArrived) {
                    blueVisited[nextBlueY][nextBlueX] = false;
                }
            }
        }
    }
}