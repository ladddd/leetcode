package leetcode

//【dp】
class _0064 {

    // f(m, n) = minof(f(m-1, n), f(m, n-1))
    class Solution {
        fun minPathSum(grid: Array<IntArray>): Int {
            val rows = grid.size
            val columns = grid.getOrNull(0)?.size ?: return 0
            val results = Array(rows) { IntArray(columns) }
            // 初始化左边
            for (row in 0 until rows) {
                results[row][0] = (results.getOrNull(row-1)?.get(0) ?: 0) + grid[row][0]
            }
            // 初始化上边
            for (col in 0 until columns) {
                results[0][col] = (results[0].getOrNull(col-1) ?: 0) + grid[0][col]
            }
            for (i in 1 until rows) {
                for (j in 1 until columns) {
                    results[i][j] = grid[i][j] + minOf(results[i-1][j] , results[i][j-1])
                }
            }
            return results[rows-1][columns-1]
        }
    }
}