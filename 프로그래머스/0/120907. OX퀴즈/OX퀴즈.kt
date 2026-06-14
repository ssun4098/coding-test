class Solution {
    fun solution(quiz: Array<String>): Array<String> {
        return quiz.map { q ->
            val (n1, op, n2, _, result) = q.split(" ")

            val calc = when (op) {
                "+" -> n1.toInt() + n2.toInt()
                "-" -> n1.toInt() - n2.toInt()
                else -> 0
            }

            if (calc == result.toInt()) "O" else "X"
        }.toTypedArray()
    }
}