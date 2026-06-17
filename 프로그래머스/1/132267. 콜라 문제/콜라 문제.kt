class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer = 0
        var bottle = n

        while (bottle >= a) {
            val newCola = (bottle / a) * b
            answer += newCola
            bottle = bottle % a + newCola
        }

        return answer
    }
}