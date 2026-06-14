class Solution {
    fun solution(numList: IntArray): IntArray {
        var even = 0;
        var odd = 0;
        
        for (i in numList) {
            when (i % 2) {
                0 -> even++
                else -> odd++
            }
        }
        
        var answer: IntArray = intArrayOf(even, odd)
        return answer
    }
}