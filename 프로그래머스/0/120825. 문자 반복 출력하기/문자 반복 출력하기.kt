class Solution {
    fun solution(myString: String, n: Int) =
        myString.map { it.toString().repeat(n) }.joinToString("")
}