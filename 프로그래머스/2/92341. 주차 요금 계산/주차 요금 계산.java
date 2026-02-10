import java.util.*;
import java.time.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Car> map = new HashMap<>();
        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record, " ");
            String[] time = st.nextToken().split(":");
            String number = st.nextToken();
            String type = st.nextToken();

            LocalTime t = LocalTime.of(
                    Integer.parseInt(time[0]),
                    Integer.parseInt(time[1])
            );

            Car car = map.getOrDefault(number, new Car(number));

            if (type.equals("IN")) {
                car.in(t);
            } else {
                car.out(t);
            }

            map.put(number, car);
        }

        for (Car car : map.values()) {
            car.closeDay();
        }
        
        int[] answer = new int[map.size()];

        List<String> carNumbers = new ArrayList<>(map.keySet());
        Collections.sort(carNumbers);

        int idx = 0;
        for (String num : carNumbers) {
            answer[idx++] = map.get(num).cal(
                    fees[0], fees[1], fees[2], fees[3]
            );
        }

        return answer;
    }
}

class Car {
    private String number;
    private LocalTime in;
    private long totalMinute = 0;

    public Car(String number) {
        this.number = number;
    }

    public void in(LocalTime time) {
        this.in = time;
    }

    public void out(LocalTime time) {
        totalMinute += Duration.between(in, time).toMinutes();
        in = null; // 정리
    }

    public void closeDay() {
        if (in != null) {
            totalMinute += Duration.between(in, LocalTime.of(23, 59)).toMinutes();
            in = null;
        }
    }

    public int cal(long defaultMinute, int defaultFee, long unitMinute, int unitFee) {
        if (totalMinute <= defaultMinute) {
            return defaultFee;
        }

        long extra = totalMinute - defaultMinute;
        int namuge = (int) Math.ceil((double) extra / unitMinute);

        return defaultFee + namuge * unitFee;
    }
}
