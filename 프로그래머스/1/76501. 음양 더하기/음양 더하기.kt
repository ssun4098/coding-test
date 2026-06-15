class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        return absolutes.zip(signs.toList())
            .sumOf { (a, sign) -> if (sign) a else -a }
    }
}