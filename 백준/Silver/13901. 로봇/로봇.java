import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(stringTokenizer.nextToken()); // 세로
            int c = Integer.parseInt(stringTokenizer.nextToken()); // 가로
            int[][] array = new int[r][c];
            int k = Integer.parseInt(br.readLine());

            for(int i = 0; i < k; i++) {
                StringTokenizer trap = new StringTokenizer(br.readLine(), " ");
                array[Integer.parseInt(trap.nextToken())][Integer.parseInt(trap.nextToken())] = -1; // -1은 함정
            }
            StringTokenizer start = new StringTokenizer(br.readLine(), " ");
            int sr = Integer.parseInt(start.nextToken());
            int sc = Integer.parseInt(start.nextToken());
            array[sr][sc] = 1;
            StringTokenizer moves = new StringTokenizer(br.readLine(), " ");
            int[] commands = new int[moves.countTokens()];
            for(int i = 0; i < commands.length; i++) {
                commands[i] = Integer.parseInt(moves.nextToken());
            }
            int count = 0;
            while(true) {
                boolean flag = true;
                int command = commands[count % commands.length];
                // 상 막힘 확인
                if(sr > 0 && array[sr - 1][sc] == 0) {
                    flag = false;
                }

                // 하 막힘 확인
                if(sr < r - 1 && array[sr + 1][sc] == 0) {
                    flag = false;
                }

                // 좌 막힘 확인
                if(sc > 0 && array[sr][sc - 1] == 0) {
                    flag = false;
                }

                // 우 막힘 확인
                if(sc < c - 1 && array[sr][sc + 1] == 0) {
                    flag = false;
                }

                // 하나라도 뚤려 있으면
                if(flag) {
                    break;
                }


                if(command == 1) {
                    while(sr > 0 && array[sr - 1][sc] == 0) {
                        array[sr - 1][sc] = 1;
                        sr--;
                    }
                    count++;
                }

                if(command == 2) {
                    while(sr < r - 1 && array[sr + 1][sc] == 0) {
                        array[sr + 1][sc] = 1;
                        sr++;
                    }
                    count++;
                }

                if(command == 3) {
                    while(sc > 0 && array[sr][sc - 1] == 0) {
                        array[sr][sc - 1] = 1;
                        sc--;
                    }
                    count++;
                }

                if(command == 4) {
                    while(sc < c - 1 && array[sr][sc + 1] == 0) {
                        array[sr][sc + 1] = 1;
                        sc++;
                    }
                    count++;
                }
            }
            bw.write(sr + " " + sc);
        }
    }
}