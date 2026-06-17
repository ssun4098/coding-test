class Solution {
    fun solution(price: Int, money: Int, count: Int): Long =
        maxOf(0, price.toLong() * count * (count + 1) / 2 - money)
}