class Solution {
    fun solution(data: Array<IntArray>, col: Int, rowBegin: Int, rowEnd: Int): Int {
    var answer = 0
    val sorted = data.sortedWith(compareBy<IntArray> { it[col-1] }.thenByDescending { it[0] })
    
    for(i in rowBegin .. rowEnd) {
        answer = answer xor sorted[i-1].sumOf { it % i }
    }
    
    return answer
    }
}