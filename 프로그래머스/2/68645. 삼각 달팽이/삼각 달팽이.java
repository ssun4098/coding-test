class Solution {
    public int[] solution(int n) {

        int[][] arr = new int[n][n];

        int num = 1;
        int row = -1;
        int col = 0;

        for(int i = 0; i < n; i++) {

            for(int j = i; j < n; j++) {

                // 아래
                if(i % 3 == 0) {
                    row++;
                }

                // 오른쪽
                else if(i % 3 == 1) {
                    col++;
                }

                // 왼쪽 위
                else {
                    row--;
                    col--;
                }

                arr[row][col] = num++;
            }
        }

        int size = n * (n + 1) / 2;
        int[] answer = new int[size];

        int idx = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                if(arr[i][j] != 0) {
                    answer[idx++] = arr[i][j];
                }
            }
        }

        return answer;
    }
}