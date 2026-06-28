class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        return dfs(numbers, target, 0, 0)
    }

    fun dfs(numbers: IntArray, target: Int, index: Int, currentSum: Int): Int {
        if (index == numbers.size) {
            return if (currentSum == target) 1 else 0
        }
        return dfs(numbers, target, index + 1, currentSum + numbers[index]) +
               dfs(numbers, target, index + 1, currentSum - numbers[index])
    }
}