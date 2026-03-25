fun main() = with(System.`in`.bufferedReader()) {
    val first = readLine().split(" ")

    val n = first[0].toInt()
    val k = first[1].toInt()

    val s = readLine().split(" ").map { it.toInt() }.toMutableList()
    val d = readLine().split(" ").map { it.toInt() }

    for(i in 0 until k) {
        val copy = s.toMutableList()

        for(j in 0 until n) {
            s[d[j] - 1] = copy[j]
        }
    }

    println(s.joinToString(" "))
}