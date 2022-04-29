package leetcode

//【dfs】
class _0200 {
    class Solution {
        fun numIslands(grid: Array<CharArray>): Int {
            if (grid.isEmpty() || grid[0].isEmpty()) return 0
            var result = 0
            for (row in grid.indices) {
                for (col in grid[0].indices) {
                    result += dfs(grid, row, col)
                }
            }
            return result
        }

        // 深度遍历每个可能岛屿
        fun dfs(grid: Array<CharArray>, row: Int, col: Int): Int {
            if (row !in grid.indices || col !in grid[0].indices || grid[row][col] == '0') return 0
            grid[row][col] = '0'
            // 递归将周围链接方格设置为0
            dfs(grid, row-1, col)
            dfs(grid, row, col-1)
            dfs(grid, row+1, col)
            dfs(grid, row, col+1)
            return 1
        }
    }
}