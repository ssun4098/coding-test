class Solution {
    fun solution(s: String): String {
        val mid = s.length / 2
        return if (s.length % 2 == 0) {
            "${s[mid - 1]}${s[mid]}"   // 문자열 템플릿으로 String 반환
        } else {
            "${s[mid]}"
        }
    }
}