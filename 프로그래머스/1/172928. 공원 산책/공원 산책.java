class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        char[][] parkArray = new char[park.length][park[0].length()];

        // 공원 배열 생성 및 시작 위치 탐색
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                parkArray[i][j] = park[i].charAt(j);

                if (parkArray[i][j] == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        for (String route : routes) {
            char op = route.charAt(0);
            int n = Integer.parseInt(String.valueOf(route.charAt(2)));

            int nextRow = answer[0];
            int nextCol = answer[1];

            boolean canMove = true;

            for (int i = 0; i < n; i++) {

                if (op == 'E') {
                    nextCol++;
                } else if (op == 'W') {
                    nextCol--;
                } else if (op == 'S') {
                    nextRow++;
                } else if (op == 'N') {
                    nextRow--;
                }

                // 범위를 벗어났는지 확인
                if (nextRow < 0 || nextRow >= parkArray.length
                        || nextCol < 0 || nextCol >= parkArray[0].length) {
                    canMove = false;
                    break;
                }

                // 장애물인지 확인
                if (parkArray[nextRow][nextCol] == 'X') {
                    canMove = false;
                    break;
                }
            }

            // 모든 이동이 가능했을 때만 실제 위치 변경
            if (canMove) {
                answer[0] = nextRow;
                answer[1] = nextCol;
            }
        }

        return answer;
    }
}