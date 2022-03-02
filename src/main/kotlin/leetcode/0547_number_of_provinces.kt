package leetcode

//【数组】【dfs】【bfs】
class _0547 {

    fun exec(args: Array<IntArray>): Int {
        return Solution().findCircleNum(args)
    }

    class Solution {

        // 省份数量, 无向连通图数量
        fun findCircleNum(isConnected: Array<IntArray>): Int {
            // 验证是正方形矩阵
            if (isConnected.isEmpty() || isConnected[0].isEmpty() || isConnected.size != isConnected[0].size) {
                return 0
            }
            var result = isConnected.size // 都不连通情况下省份数量
            val visited = BooleanArray(isConnected.size) { false } // 用一个数组存访问过的节点
            for (i in isConnected.indices) {
                if (visited[i]) continue
                val count = dfs(isConnected, i, visited)
                result -= count - 1 // count数量的城市计算为一个省份
            }
            return result
        }

        // 查找第index个城市的连通城市
        fun dfs(grid: Array<IntArray>, index: Int, visited: BooleanArray): Int {
            var result = 0
            // 访问可能邻接的城市
            for (i in grid.indices) {
                if (grid[index][i] == 1 && grid[i][index] == 1 && !visited[i]) {
                    visited[i] = true
                    result += 1 + dfs(grid, i, visited)
                }
            }
            return result
        }
    }
}