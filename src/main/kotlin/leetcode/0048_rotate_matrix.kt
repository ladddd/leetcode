package leetcode

//【矩阵】
class _0048 {

    // matrix[row][col] = matrix[col][n-1-row]
    class Solution {
        fun rotate(matrix: Array<IntArray>): Unit {
            // 矩阵计算
            // 矩阵顺时针旋转90度 = 矩阵水平翻转 then 对角线翻转（左上-右下）
            val size = matrix.size // 矩阵的维度
            // step1 翻转是置换一半的行
            for (i in 0 until size / 2) {
                val temp = matrix[i]
                matrix[i] = matrix[size-1-i]
                matrix[size-1-i] = temp
            }
            for (i in 0 until size) {
                for (j in i until size) { //
                    val temp = matrix[i][j]
                    matrix[i][j] = matrix[j][i]
                    matrix[j][i] = temp
                }
            }
        }
    }
}