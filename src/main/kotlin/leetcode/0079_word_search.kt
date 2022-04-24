package leetcode

//【dfs】【回溯】
class _0079 {

    class Solution {
        fun exist(board: Array<CharArray>, word: String): Boolean {
            if (word.isEmpty()) return true
            if (board.isEmpty() || board[0].isEmpty()) return false
            val rows = board.size
            val cols = board[0].size
            val visited = Array(rows) { Array(cols) { false } }
            // 需要一个二维数组保存元素是否被访问过
            for (row in 0 until rows) {
                for (col in 0 until cols) {
                    if (checkChar(board, row, col, visited, word, 0)) {
                        return true
                    }
                }
            }
            return false
        }

        // 递归检测从 row col 位置出发是否能
        fun checkChar(board: Array<CharArray>, row: Int, col: Int, visited: Array<Array<Boolean>>, word: String, index: Int): Boolean {
            if (row !in board.indices || col !in board[0].indices) {
                return false
            }
            if (visited[row][col]) {
                return false
            }
            visited[row][col] = true
            if (board[row][col] == word[index]) {
                visited[row][col] = true
                if (index == word.length-1) {
                    return true
                } else if (checkChar(board, row-1, col, visited, word, index+1)) {
                    // 向左侧遍历
                    return true
                } else if (checkChar(board, row, col-1, visited, word, index+1)) {
                    // 上
                    return true
                } else if (checkChar(board, row+1, col, visited, word, index+1)) {
                    // 右
                    return true
                } else if (checkChar(board, row, col+1, visited, word, index+1)) {
                    // 下
                    return true
                }
            }
            // *一个点完成后还原状态
            // 回溯
            visited[row][col] = false
            return false
        }
    }
}