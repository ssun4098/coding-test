class Solution {
    fun solution(s: String): Boolean {
        if(s.length != 4 && s.length != 6) {
            return false
        }
        for(c in s) {
            if(!c.isDigit()) {
                return false
            }
        }
        return true
    }
}