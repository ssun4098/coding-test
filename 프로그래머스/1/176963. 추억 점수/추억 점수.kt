class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val map = mutableMapOf<String, Int>()
        val list = mutableListOf<Int>()
        
        for((i, n) in name.withIndex()) {
            map.put(name[i], yearning[i])
        }
        
        for(array in photo) {
            var sum = 0
            for(k in array) {
                sum += map.getOrDefault(k, 0)
            }
            list.add(sum)
        }
        
        return list.toIntArray()
    }
}