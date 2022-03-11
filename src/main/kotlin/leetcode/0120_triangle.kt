package leetcode

//【dp】
class _0120 {

    fun exec(args: List<List<Int>>): Int {
        return Solution().minimumTotal(args)
    }

    //1
    //2,3
    //4,5,6
    //7,8,9,10
    //左对齐可以清晰看出父子节点纵坐标上的关系
    class Solution {

        // dp
        // 用二维数组保存每个节点上的最小路径
        // 从上到下单向的，最小路径只需要考虑左右两个父亲
        // 这个是从上往下推
        fun minimumTotal3(triangle: List<List<Int>>): Int {
            // 开一个二维数组
            val dp = Array<Array<Int>>(triangle.size) { i: Int -> Array(i+1) {0} }
            for (i in triangle.indices) {
                for (j in triangle[i].indices) {
                    val left = dp.getOrNull(i-1)?.getOrNull(j-1) // 左边父亲的最端路径
                    val right = dp.getOrNull(i-1)?.getOrNull(j) // 右边
                    var sum = triangle[i][j]
                    if (left != null) {
                        if (right != null) {
                            sum += minOf(left, right)
                        } else {
                            sum += left
                        }
                    } else if (right != null) {
                        sum += right
                    }
                    dp[i][j] = sum
                }
            }
            return dp[triangle.size - 1].minOrNull() ?: 0
        }

        // dp 数组只开一维，只保存下一层的所有节点的最短路径
        fun minimumTotal(triangle: List<List<Int>>): Int {
            val dp = Array<Int>(triangle.size) { 0 } // 高度为n的三角，最底层有n个元素
            for (i in triangle.size - 1 downTo 0) {
                for (j in triangle[i].indices) {
                    val left = dp.getOrNull(j) // 左边子节点
                    val right = dp.getOrNull(j+1) // 右边子节点
                    var sum = triangle[i][j]
                    if (left != null) {
                        if (right != null) {
                            sum += minOf(left, right)
                        } else {
                            sum += left
                        }
                    } else if (right != null) {
                        sum += right
                    }
                    dp[j] = sum
                }
            }
            return dp[0]
        }


        // dfs遍历，暴力求解
        // 会超时，考虑剪枝方法
        fun minimumTotal2(triangle: List<List<Int>>): Int {
            return dfs(triangle, 0, 0)
        }

        fun dfs(triangle: List<List<Int>>, level: Int, index: Int): Int {
            if (level >= triangle.size) {
                return 0 //
            }
            var sum = triangle[level][index] // 当前节点
            // 加上左孩子右孩子
            sum += minOf(dfs(triangle, level+1, index), dfs(triangle, level+1, index+1))
            return sum
        }
    }


}