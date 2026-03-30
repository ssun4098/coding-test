import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static String NO = "No";
    private static String OKAY = "Okay";

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());


            Map<String, Integer> normal = new HashMap<>();
            Map<String, Integer> special = new HashMap<>();
            Map<String, Integer> service = new HashMap<>();

            input(a, normal, br);
            input(b, special, br);
            input(c, service, br);

            int n = Integer.parseInt(br.readLine());
            String[] orders = new String[n];
            for(int i = 0; i < n; i++) {
                orders[i] = br.readLine();
            }

            System.out.println(result(normal, special, service, orders));
        }
    }

    public static void input(int n, Map<String, Integer> map, BufferedReader br) throws IOException {
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int price = 0;
            if(st.hasMoreTokens()) {
                price = Integer.parseInt(st.nextToken());
            }

            map.put(name, price);
        }
    }

    public static String result(Map<String, Integer> normal,
                                Map<String, Integer> special,
                                Map<String, Integer> service,
                                String[] orders) {
        long normalSumPrice = 0;

        long specialSumPrice = 0;
        int specialCount = 0;

        int serviceCount = 0;

        for(String order: orders) {
            Integer normalPrice = normal.getOrDefault(order, -1);
            Integer specialPrice = special.getOrDefault(order, -1);
            Integer servicePrice = service.getOrDefault(order, -1);

            if(normalPrice > 0) {
                normalSumPrice += normalPrice;
                continue;
            }

            if(specialPrice > 0) {
                specialSumPrice += specialPrice;
                specialCount++;
                continue;
            }


            if(servicePrice > -1) {
                serviceCount++;
            }
        }

        if(specialCount > 0 && normalSumPrice < 20000) {
            return NO;
        }

        if(serviceCount > 0 && normalSumPrice + specialSumPrice < 50000) {
            return NO;
        }

        if(serviceCount > 1) {
            return NO;
        }

        return OKAY;
    }
}