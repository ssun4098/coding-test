class Solution {
    fun solution(number: IntArray): Int {
        var answer = 0
        val n = number.size

        for (i in 0 until n - 2) {
            for (j in i + 1 until n - 1) {
                for (k in j + 1 until n) {
                    if (number[i] + number[j] + number[k] == 0) answer++
                }
            }
        }

        return answer
    }
}