package leetcode

//【dp】
class _0211 {

    fun exec(args: Array<CharArray>): Int {
        return Solution().maximalSquare(args)
    }

    class Solution {

        // dp，开一个二维数组，存放以该节点为右下角，区域内全为1的矩形边长
        fun maximalSquare(matrix: Array<CharArray>): Int {
            if (matrix.isEmpty() || matrix[0].isEmpty()) return 0
            var result = 0
            val dp = Array<IntArray>(matrix.size) { IntArray(matrix[0].size) {0} }
            for (row in matrix.indices) {
                for (column in matrix[0].indices) {
                    if (matrix[row][column] != '1') {
                        dp[row][column] = 0
                    } else {
                        val left = dp.getOrNull(row-1)?.getOrNull(column) ?: 0
                        val top = dp.getOrNull(row)?.getOrNull(column-1) ?: 0
                        val leftTop = dp.getOrNull(row-1)?.getOrNull(column-1) ?: 0
                        val max = 1 + minOf(left, top, leftTop)
                        val square = max * max
                        dp[row][column] = max
                        if (square > result) {
                            result = square
                        }
                    }
                }
            }
            return result
        }

        // 暴力
        fun maximalSquare2(matrix: Array<CharArray>): Int {
            if (matrix.isEmpty() || matrix[0].isEmpty()) return 0
            var result = 0
            for (row in matrix.indices) {
                for (column in matrix[0].indices) {
                    if (matrix[row][column] != '1') continue
                    var size = 1
                    // 从左上角开始遍历
                    val range = if (matrix.size - row < matrix[0].size - column) matrix.size-row else matrix[0].size-column
                    for (i in 1 until range) {
                        // 判断以(row,column)为左上角，i+1边长的矩形中是否有非 1
                        // part 1, 右下角
                        if (matrix[row+i][column+i] != '1') break
                        for (j in 0 until i) {
                            // column + i 列，row + i行同时遍历
                            if (matrix[row+i][column+j] != '1' || matrix[row+j][column+i] != '1') {
                                break
                            }
                        }
                        size = i
                    }
                    result = if (size * size > result) size * size else result
                }
            }
            return result
        }
    }
}