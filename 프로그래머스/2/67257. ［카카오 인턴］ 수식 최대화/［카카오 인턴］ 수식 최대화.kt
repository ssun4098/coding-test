import kotlin.math.max

class Solution {
var answer = 0L
var array = arrayOf("+", "-", "*")
val regex = Regex("\\d+|[+\\-*]")
fun solution(expression: String): Long {
    val tokens = regex.findAll(expression)
        .map { it.value }
        .toMutableList()

    dfs(tokens, BooleanArray(3))
    return answer
}

fun dfs(tokens: MutableList<String>, visited: BooleanArray) {
    if (tokens.size == 1) {
        answer = max(answer, kotlin.math.abs(tokens[0].toLong()))
        return
    }

    for ((i, v) in visited.withIndex()) {
        if (!v) {
            visited[i] = true

            val newTokens = tokens.toMutableList()

            var index = newTokens.indexOf(array[i])

            while (index != -1) {
                val result = when (array[i]) {
                    "+" -> newTokens[index - 1].toLong() + newTokens[index + 1].toLong()
                    "-" -> newTokens[index - 1].toLong() - newTokens[index + 1].toLong()
                    else -> newTokens[index - 1].toLong() * newTokens[index + 1].toLong()
                }

                newTokens[index - 1] = result.toString()
                newTokens.removeAt(index + 1)
                newTokens.removeAt(index)

                index = newTokens.indexOf(array[i])
            }

            dfs(newTokens, visited)

            visited[i] = false
        }
    }
}
}