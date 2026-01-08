import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++){
                String[] s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);

                List<Integer> aList = new ArrayList<>();
                List<Integer> bList = new ArrayList<>();

                String[] aInput = br.readLine().split(" ");
                String[] bInput = br.readLine().split(" ");

                for (String string : aInput) {
                    aList.add(Integer.parseInt(string));
                }
                for (String string : bInput) {
                    bList.add(Integer.parseInt(string));
                }

                Collections.sort(aList);
                Collections.sort(bList);

                int[] array = new int[aList.size()];
                int flag = 0;
                for(int j = 0; j < aList.size(); j++){
                    int count = 0;
                    for(int k = flag; k < bList.size(); k++){
                        if(aList.get(j) > bList.get(k)){
                            count++;
                            flag = k+1;
                            continue;
                        }
                        break;
                    }
                    if(j > 0) {
                        array[j] += array[j-1] + count;
                    } else {
                        array[j] += count;
                    }
                }
                sb.append(Arrays.stream(array).sum());
                if (i < n - 1) sb.append('\n');
            }
            bw.write(sb.toString());
        }
    }
}