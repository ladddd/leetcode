package leetcode

//【树】【DFS】【BFS】
class _0695 {

    fun exec(args: Array<IntArray>): Int {
        return Solution().maxAreaOfIsland(args)
    }

    class Solution {
        fun maxAreaOfIsland(grid: Array<IntArray>): Int {
            if (grid.isEmpty()) return 0
            var result = 0
            val maxRow = grid.size
            val maxColumn = grid[0].size
            for (i in 0 until maxRow) {
                for (j in 0 until maxColumn) {
                    if (grid[i][j] == 0) {
                        continue
                    }
                    val single = dfs(grid, i, j)
                    result = if (single > result) single else result
                }
            }
            return result
        }

        // 计算每个岛的面积
        fun dfs(grid: Array<IntArray>, row: Int, column: Int): Int {
            // 跳出条件，坐标不在图内, 或value不为1（非岛屿面积）
            if (row >= grid.size || column >= grid[0].size || row < 0 || column < 0 || grid[row][column] != 1) {
                return 0
            }
            grid[row][column] = 0
            var result = 1
            // 从中心开始，继续遍历连通的地块，四个方向
            // 此处还可以搭配栈实现DFS，或者搭配队列实现BFS
            result += dfs(grid, row+1, column)
            result += dfs(grid, row-1, column)
            result += dfs(grid, row, column+1)
            result += dfs(grid, row, column-1)
            return result
        }
    }
}