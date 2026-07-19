class Solution {
fun solution(citations: IntArray): Int {
    citations.sort()

    for (i in citations.indices) {
        val h = citations.size - i
        if (citations[i] >= h)
            return h
    }
    return 0
}
}