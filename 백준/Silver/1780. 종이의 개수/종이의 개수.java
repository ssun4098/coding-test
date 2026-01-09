import java.io.*;

public class Main {
    private static int[][] array;
    private static int[] answer = new int[3];

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
            int n = Integer.parseInt(br.readLine());
            array = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().split(" ");
                for(int j = 0; j < n; j++){
                    array[i][j] = Integer.parseInt(s[j]);
                }
            }
            find(0, n, 0, n);
            bw.write(answer[0] + "\n" + answer[1] + "\n" + answer[2]);
        }
    }

    public static void find(int x1, int x2, int y1, int y2) {
        if(x2 <= x1 || y2 <= y1){
            return;
        }

        if(check(x1, x2, y1, y2, -1)) {
            answer[0]++;
            return;
        }

        if(check(x1, x2, y1, y2, 0)) {
            answer[1]++;
            return;
        }

        if(check(x1, x2, y1, y2, 1)) {
            answer[2]++;
            return;
        }

        int xDivLength = (x2 - x1) / 3;
        int yDivLength = (y2 - y1) / 3;


        for(int i = 0; i < 3; i++) {
            forX(x1, xDivLength, y1 + yDivLength * i, y1 + yDivLength * (i + 1));
        }
    }

    private static void forX(int x1, int xDivLength, int y1, int y2){
        find(x1, x1 + xDivLength, y1, y2);
        find(x1 + xDivLength, x1 + xDivLength * 2, y1, y2);
        find(x1 + xDivLength * 2, x1 + xDivLength * 3, y1, y2);
    }

    public static boolean check(int x1, int x2, int y1, int y2, int value) {
        for(int i = x1; i < x2; i++) {
            for(int j = y1; j < y2; j++) {
                if(array[j][i] != value){
                    return false;
                }
            }
        }
        return true;
    }
}