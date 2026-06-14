class Solution {
    fun solution(a: IntArray, b: IntArray): Int = (0 .. a.size - 1).map {
        it -> a[it] * b[it]
    }.toIntArray().sum()
}