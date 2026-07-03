class Solution {
fun appendGroup(sb: StringBuilder, count: Int, word: String) {
    if (count > 1) sb.append(count)
    sb.append(word)
}

fun solution(s: String): Int {
    var answer = s.length

    for(i in 1 until s.length - 1) {
        val chunked = s.chunked(i)
        var count = 0
        var last: String? = null
        val sb = StringBuilder()
        for(word in chunked) {
            if(word == last) {
                count++
                continue
            }
            last?.let { appendGroup(sb, count, it) }
            count = 1
            last = word
        }
        appendGroup(sb, count, last!!)
        answer = minOf(answer, sb.length)
    }

    return answer
}
}