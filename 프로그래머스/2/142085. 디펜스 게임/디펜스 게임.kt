

import java.util.*

class Solution {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
    var soldiers = n.toLong()
    val pq = PriorityQueue<Int>()
    
    for (i in enemy.indices) {
        pq.add(enemy[i])
        if (pq.size > k) {
            soldiers -= pq.poll()
        }
        if (soldiers < 0) return i
    }
    return enemy.size
}
}