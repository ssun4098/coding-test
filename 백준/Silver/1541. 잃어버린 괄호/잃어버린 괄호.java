import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] subtractionGroups = br.readLine().split("-");
        int finalResult = Integer.MAX_VALUE;

        for (String group : subtractionGroups) {
            int tempSum = 0;
            String[] additionNumbers = group.split("\\+");
            for (String num : additionNumbers) {
                tempSum += Integer.parseInt(num);
            }

            if (finalResult == Integer.MAX_VALUE) {
                finalResult = tempSum;
            } else {
                finalResult -= tempSum;
            }
        }
        
        System.out.println(finalResult);
    }
}