package leetcode

//【dp】
class _0062 {

    class Solution {

        // 动态方程 f(i, j) = f(i-1, j) + f(i, j-1) 左边+上边
        fun uniquePaths(m: Int, n: Int): Int {
            // 用一个二维数组存放结果
            val results = Array<Array<Int>>(m) { Array(n) { 0 } }
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (i == 0 || j == 0) {
                        // 在左侧或上侧边缘 左+上 = f(0, 0) = 1
                        results[i][j] = 1
                    } else {
                        results[i][j] = results[i - 1][j] + results[i][j - 1]
                    }
                }
            }
            return results[m-1][n-1]
        }
    }
}