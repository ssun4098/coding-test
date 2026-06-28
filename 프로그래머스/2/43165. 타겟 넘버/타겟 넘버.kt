class Solution {
    
    var answer = 0
    
fun solution(numbers: IntArray, target: Int): Int {
    val array = BooleanArray(numbers.size)
    array[0] = true
    dfs(numbers, target, 1, array)
    array[0] = false
    dfs(numbers, target, 1, array)
    return answer
}

fun dfs(numbers: IntArray, target: Int, index: Int, array: BooleanArray) {
    if(index == numbers.size) {
        var sum = 0
        for((i, v) in numbers.withIndex()) {
            if(array[i]) {
                sum += v
            } else {
                sum -= v
            }
        }
        if(sum == target) {
            answer++
        }
        return
    }
    array[index] = true
    dfs(numbers, target, index+1, array);
    array[index] = false
    dfs(numbers, target, index+1, array);
}
}