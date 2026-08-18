class Solution {
    private static final int[] BURGER = {1, 2, 3, 1};

    public int solution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int top = 0;
        int answer = 0;

        for (int item : ingredient) {
            stack[top++] = item;
            if (isBurgerOnTop(stack, top)) {
                top -= BURGER.length;
                answer++;
            }
        }
        return answer;
    }

    private boolean isBurgerOnTop(int[] stack, int top) {
        if (top < BURGER.length) return false;
        for (int i = 0; i < BURGER.length; i++) {
            if (stack[top - BURGER.length + i] != BURGER[i]) return false;
        }
        return true;
    }
}