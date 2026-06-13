class Solution {
    fun solution(money: Int): IntArray {
        val iceAmericanoCount = money / 5500
        val change = money % 5500;
        var answer: IntArray = intArrayOf(iceAmericanoCount, change)
        return answer
    }
}