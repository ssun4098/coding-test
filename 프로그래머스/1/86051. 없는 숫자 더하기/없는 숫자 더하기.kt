class Solution {
//     fun solution(numbers: IntArray): Int {
//         var answer: Int = (1 .. 9).sum()
        
//         for(i in numbers) {
//             answer -= i
//         }
        
//         return answer
//     }
    
    fun solution(numbers: IntArray): Int = (1 .. 9).sum() - numbers.sum()
}