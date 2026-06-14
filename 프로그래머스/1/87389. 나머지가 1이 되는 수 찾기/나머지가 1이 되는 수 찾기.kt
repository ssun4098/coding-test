class Solution {
    fun solution(n: Int): Int {
        var answer: Int = n - 1
        
        for(i in 2 .. n) {
            if(n % i == 1) {
                answer = Math.min(answer, i)
            }
        }
        
        return answer
    }
}