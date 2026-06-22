class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer = intArrayOf(0, sequence.lastIndex)
        var left = 0
        var right = 0
        var sum = sequence[0]

        while (right < sequence.size) {
            if (sum == k) {
                if (right - left < answer[1] - answer[0]) {
                    answer = intArrayOf(left, right)
                }
                sum -= sequence[left++]
            } else if (sum < k) {
                if (++right < sequence.size) sum += sequence[right]
            } else {
                sum -= sequence[left++]
            }
        }

        return answer
    }
}