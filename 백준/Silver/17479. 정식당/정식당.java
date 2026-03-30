import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final String NO = "No";
    private static final String OKAY = "Okay";

    enum FoodType {
        NORMAL,
        SPECIAL,
        SERVICE
    }

    static class Food {

        private FoodType type;
        private int price;

        public Food(FoodType type, int price) {
            this.type = type;
            this.price = price;
        }

        public boolean isNormal() {
            return type == FoodType.NORMAL;
        }

        public boolean isSpecial() {
            return type == FoodType.SPECIAL;
        }

        public boolean isService() {
            return type == FoodType.SERVICE;
        }

        public int getPrice() {
            return price;
        }
    }

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            Map<String, Food> menu = new HashMap<>();

            input(a, menu, br, FoodType.NORMAL);
            input(b, menu, br, FoodType.SPECIAL);
            input(c, menu, br, FoodType.SERVICE);

            int n = Integer.parseInt(br.readLine());

            long normalSum = 0;
            long specialSum = 0;

            int specialCount = 0;
            int serviceCount = 0;

            for(int i = 0; i < n; i++) {

                String order = br.readLine();

                Food food = menu.get(order);

                if(food.isNormal()) {
                    normalSum += food.getPrice();
                }
                else if(food.isSpecial()) {
                    specialSum += food.getPrice();
                    specialCount++;
                }
                else if(food.isService()) {
                    serviceCount++;
                }
            }

            System.out.println(
                    validate(normalSum, specialSum, specialCount, serviceCount)
            );
        }
    }

    public static void input(int n,
                             Map<String, Food> menu,
                             BufferedReader br,
                             FoodType type) throws IOException {

        for(int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();

            int price = 0;

            if(type != FoodType.SERVICE) {
                price = Integer.parseInt(st.nextToken());
            }

            menu.put(name, new Food(type, price));
        }
    }

    public static String validate(long normalSum,
                                  long specialSum,
                                  int specialCount,
                                  int serviceCount) {

        if(specialCount > 0 && normalSum < 20000) {
            return NO;
        }

        if(serviceCount > 0 && normalSum + specialSum < 50000) {
            return NO;
        }

        if(serviceCount > 1) {
            return NO;
        }

        return OKAY;
    }
}