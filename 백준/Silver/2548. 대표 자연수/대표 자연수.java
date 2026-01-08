import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
            int n = Integer.parseInt(br.readLine());
            int[] array = new int[n];
            String[] s = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(s[i]);
            }
            int min = Integer.MAX_VALUE;
            int value = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                int result = 0;
                for(int j = 0; j < n; j++) {
                    result += Math.abs(array[i] - array[j]);
                }

                if(result == value) {
                    min = Math.min(array[i], min);
                    continue;
                }

                if(result < value){
                    min = array[i];
                    value = result;
                }
            }
            bw.write(String.valueOf(min));
        }
    }
}