class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        arrayA.sort()
        arrayB.sort()
        
        val condition1 = condition(arrayA, arrayB)
        val condition2 = condition(arrayB, arrayA)
        val result = condition1 + condition2
        
        return result.maxOrNull() ?: 0
    }
    
        
    fun condition(arrayA: IntArray, arrayB: IntArray) : List<Int> {
        val r = (2..arrayA[0]).filter { i ->
            arrayA.all { a -> a % i == 0 }
        }.toMutableList()

        r.removeAll { v ->
            arrayB.any { b -> b % v == 0 }
        }
        return r
    }
}