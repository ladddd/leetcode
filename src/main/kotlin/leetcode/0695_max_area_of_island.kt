package leetcode

import java.util.*

//【树】【DFS】【BFS】
class _0695 {

    fun exec(args: Array<IntArray>): Int {
        return Solution().maxAreaOfIsland2(args)
    }

    class Solution {
        fun maxAreaOfIsland(grid: Array<IntArray>): Int {
            if (grid.isEmpty()) return 0
            val target = Array<IntArray>(grid.size) { intArrayOf() }
            // 拷贝一份grid，不要修改原始数组
            grid.copyInto(target)
            var result = 0
            val maxRow = target.size
            val maxColumn = target[0].size
            for (i in 0 until maxRow) {
                for (j in 0 until maxColumn) {
                    if (target[i][j] == 0) {
                        continue
                    }
                    val isle = dfs(target, i, j)
                    result = if (isle > result) isle else result
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

        fun maxAreaOfIsland2(grid: Array<IntArray>): Int {
            if (grid.isEmpty()) return 0
            val target = Array<IntArray>(grid.size) { intArrayOf() }
            // 拷贝一份grid，不要修改原始数组
            grid.copyInto(target)
            var result = 0
            val maxRow = target.size
            val maxColumn = target[0].size
            val stack = Stack<IntArray>()
            val queue = ArrayDeque<IntArray>(100) // arrayqueue基于数组，需要给定一个capacity
            for (i in 0 until maxRow) {
                for (j in 0 until maxColumn) {
//                    stack.push(intArrayOf(i, j))
//                    val isle = dfs2(grid, stack)
                    queue.offer(intArrayOf(i, j))
                    val isle = bfs(grid, queue)
                    result = if (isle > result) isle else result
                }
            }
            return result
        }

        fun bfs(grid: Array<IntArray>, queue: Queue<IntArray>): Int {
            var result = 0
            while (queue.isNotEmpty()) {
                val pair = queue.remove()
                val row = pair?.getOrNull(0) ?: continue
                val column = pair.getOrNull(1) ?: continue
                if (row >= grid.size || column >= grid[0].size || row < 0 || column < 0 || grid[row][column] != 1) {
                    continue
                }
                grid[row][column] = 0
                result++
                // 将四个方位append到队列中, left - top - right - bottom
                // 会先遍历完一个节点的子节点
                queue.offer(intArrayOf(row-1, column))
                queue.offer(intArrayOf(row, column-1))
                queue.offer(intArrayOf(row+1, column))
                queue.offer(intArrayOf(row, column+1))
            }
            return result
        }

        fun dfs2(grid: Array<IntArray>, stack: Stack<IntArray>): Int {
            var result = 0
            while (stack.isNotEmpty()) {
                val pair = stack.pop()
                val row = pair?.getOrNull(0) ?: continue
                val column = pair.getOrNull(1) ?: continue
                if (row >= grid.size || column >= grid[0].size || row < 0 || column < 0 || grid[row][column] != 1) {
                    continue
                }
                grid[row][column] = 0
                result++
                // 将四个方位压入栈中, left - top - right - bottom
                // 会从左边的节点遍历到该方向的最深处
                stack.push(intArrayOf(row-1, column))
                stack.push(intArrayOf(row, column-1))
                stack.push(intArrayOf(row+1, column))
                stack.push(intArrayOf(row, column+1))
            }
            return result
        }
    }
}