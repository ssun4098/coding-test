class Solution {
    
fun isValid(pos: Position, n: Int, grid: Array<IntArray>) =
    pos.row in 0 until n && pos.col in 0..pos.row && grid[pos.row][pos.col] == 0

fun solution(n: Int): IntArray {
    val total = n * (n + 1) / 2
    val grid = Array(n) { IntArray(n) }
    var pos = Position(0, 0)
    var dir = Direction.DOWN

    for (num in 1..total) {
        grid[pos.row][pos.col] = num
        if (!isValid(pos.move(dir), n, grid)) dir = dir.turn()
        pos = pos.move(dir)
    }

    return grid.flatMap { row -> row.filter { it != 0 } }.toIntArray()
}
}

enum class Direction(val dr: Int, val dc: Int) {
    DOWN(1, 0),
    RIGHT(0, 1),
    DIAGONAL(-1, -1);

    fun turn() = entries[(ordinal + 1) % entries.size]
}

data class Position(val row: Int, val col: Int) {
    fun move(dir: Direction) = Position(row + dir.dr, col + dir.dc)
}
