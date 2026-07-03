class Solution {
fun solution(s: String): Int {
    var answer = s.length

    for(i in 1 until s.length - 1) {
        val chunked = s.chunked(i)
        var count = 0
        var last = ""
        val sb = StringBuilder()
        for(word in chunked) {
            if(word != last) {
                if(last != "") {
                    if(count == 1) {
                        sb.append(last)
                    } else {
                        sb.append("$count$last")
                    }
                }
                count = 1
                last = word
            } else {
                count++
            }
        }
        if(count == 1) {
            sb.append(last)
        } else {
            sb.append("$count$last")
        }
        answer = minOf(answer, sb.length)
    }

    return answer
}
}