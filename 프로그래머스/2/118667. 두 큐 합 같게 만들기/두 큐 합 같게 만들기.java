import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int count = 0;
        int limit = queue1.length * 3;
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        long target = (sum1 + sum2) / 2;
Deque<Integer> q1 = new ArrayDeque<>();
Deque<Integer> q2 = new ArrayDeque<>();

for (int n : queue1) {
    q1.offer(n);
}

for (int n : queue2) {
    q2.offer(n);
}
        
while (count <= limit) {
    if (sum1 == target) return count;

    if (sum1 > target) {
        int x = q1.poll();
        sum1 -= x;
        q2.offer(x);
    } else {
        int x = q2.poll();
        sum1 += x;
        q1.offer(x);
    }

    count++;
}
        
        
        return -1;
    }
}