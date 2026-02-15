class Solution {
    public static int[] array = new int[100001];
    public int solution(int n) {
        if(array[n] != 0) {
            return array[n];
        }
        if(n == 1) {
            return 1;
        }
        if(n == 0) {
            return 0;
        }
        array[n] = (solution(n - 1) + solution(n - 2)) % 1234567;
        return array[n];
    }
}