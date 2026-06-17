class Solution {
fun solution(s: String): String {
    var list = mutableListOf<String>()

    for(s2 in s.split(" ")) {
        var temp = ""
        for(i in s2.indices) {
            if(i % 2 == 0) {
                temp += s2[i].uppercaseChar().toString()
            } else {
                temp += s2[i].lowercaseChar().toString()
            }
        }
        list.add(temp)
    }



    return list.joinToString(" ")
}
}