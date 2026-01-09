import java.io.*;

public class Main {
    private static int[][] array;
    private static StringBuilder sb = new StringBuilder();
    private static StringBuilder sb2 = new StringBuilder();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
            int n = Integer.parseInt(br.readLine());
            array = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().split("");
                for(int j = 0; j < n; j++){
                    array[i][j] = Integer.parseInt(s[j]);
                }
            }
            find(0, n, 0, n);
            bw.write(sb.toString());
        }
    }

    public static void find(int x1, int x2, int y1, int y2) {
        if(x2 <= x1 || y2 <= y1){
            return;
        }

        if(check(x1, x2, y1, y2, 1)) {
            sb.append(1);
            return;
        }

        if(check(x1, x2, y1, y2, 0)) {
            sb.append(0);
            return;
        }
        sb.append("(");
        find(x1, (x1 + x2) / 2, y1, (y1 + y2) / 2);
        find((x1 + x2) / 2, x2, y1, (y1 + y2) / 2);
        find(x1, (x1 + x2) / 2, (y1 + y2) / 2, y2);
        find((x1 + x2) / 2, x2, (y1 + y2) / 2, y2);
        sb.append(")");
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