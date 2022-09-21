package leetcode

//【数组】
class _1252 {
    class Solution {
        fun oddCells(m: Int, n: Int, indices: Array<IntArray>): Int {
            var result = 0
            // indices 为一个操作数组，每个操作由两个数组成（IntArray）[ri, ci] ri行每个元素+1，ci列每个元素+1
            val matrix = Array(m) { Array(n) {0} }
            for (action in indices) {
                for (i in 0 until n) {
                    matrix[action[0]][i]++
                }
                for (j in 0 until m) {
                    matrix[j][action[1]]++
                }
            }
            matrix.forEach { row ->
                result += row.count { it % 2 == 1 }
            }
            return result
        }
        // 不用二维数组，用两个一维数组记录行行和列所消耗的空间更少
//        val rows = Array(m) {0}
//        val columns = Array(n) {0}
//        for (i in rows.indices) {
//            for (j in columns.indices) {
//                result += (rows[i] + columns[j]) % 2 == 1
//            }
//        }
    }
}