import java.util.*;

class Solution {

    public String[] solution(String[][] plans) {
        List<String> result = new ArrayList<>();

        Arrays.sort(plans, Comparator.comparingInt(p -> toMinute(p[1])));

        Deque<Work> stack = new ArrayDeque<>();

        for (int i = 0; i < plans.length - 1; i++) {
            String name = plans[i][0];
            int start = toMinute(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);

            int nextStart = toMinute(plans[i + 1][1]);

            int availableTime = nextStart - start;

            if (playTime <= availableTime) {
                result.add(name);

                int remainTime = availableTime - playTime;

                while (remainTime > 0 && !stack.isEmpty()) {
                    Work paused = stack.pop();

                    if (paused.playTime <= remainTime) {
                        remainTime -= paused.playTime;
                        result.add(paused.name);
                    } else {
                        paused.playTime -= remainTime;
                        stack.push(paused);
                        remainTime = 0;
                    }
                }
            } else {
                stack.push(new Work(
                    name,
                    playTime - availableTime
                ));
            }
        }

        result.add(plans[plans.length - 1][0]);

        while (!stack.isEmpty()) {
            result.add(stack.pop().name);
        }

        return result.toArray(new String[0]);
    }

    private int toMinute(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60
             + Integer.parseInt(split[1]);
    }

    static class Work {
        String name;
        int playTime;

        Work(String name, int playTime) {
            this.name = name;
            this.playTime = playTime;
        }
    }
}