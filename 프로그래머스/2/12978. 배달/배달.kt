import kotlin.math.min

class Solution {
fun solution(n: Int, road: Array<IntArray>, k: Int): Int {
    val answer = mutableSetOf<Int>()
    val visited = mutableSetOf<Triple<Int, Int, Int>>()

    val array = Array(n + 1) { IntArray(n + 1) }
    val deque = ArrayDeque<Triple<Int, Int, Int>>()
    deque.add(Triple(0, 1, 0))
    for(r in road) {
        if (array[r[0]][r[1]] == 0 || array[r[0]][r[1]] > r[2]) {
            array[r[0]][r[1]] = r[2]
            array[r[1]][r[0]] = r[2]
        }
    }

    while(deque.isNotEmpty()) {
        val (a, b, v) = deque.first()
        deque.removeFirst()

        if (visited.contains(Triple(a, b, v))) continue
        visited.add(Triple(a, b, v))
        answer.add(b)

        for((i, dist) in array[b].withIndex()) {
            if(dist != 0 && k >= v + dist) {
                deque.add(Triple(b, i, v + dist))
            }
        }
    }

    return answer.size
}
}