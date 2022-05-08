package leetcode

//【dp】
class _0312 {
    class Solution {
        // 射击一个气球，获得自身*左左边*右边的分数，求可能的最大分数
        // 戳爆气球后，该位置不存在了
        // 递推方程：dp[i][j](i-j的最大分数, 开区间(i,j)) = dp[i][k] + dp[k][j] + nums[k] * nums[i] * nums[j] // k代表最近一个戳的气球
        fun maxCoins(nums: IntArray): Int {
            val dp = Array(nums.size+2) { Array(nums.size+2) {0} }
            // 从初始状态1个气球开始，逐渐用递推方程扩大区间，先计算所有长度为开区间只有一个元素的dp值
            // 1-n, 先计算(0,2) (1,3)..(n-1, n+1)
            for (length in 3 .. nums.size+2) {
                // i 表示开区间起始下标
                for (i in 0..nums.size+2 - length) {
                    var resultI2J = 0
                    // j 表示开区间结束下标
                    val j = i+length-1
                    // k in (i,j) 求其中最大值
                    for (k in i+1 until j) {
                        val left = dp[i][k]
                        val right = dp[k][j]
                        resultI2J = maxOf(resultI2J, left+right+nums.getOrElse(k){1} * nums.getOrElse(i){1} * nums.getOrElse(j){1})
                    }
                    dp[i][j] = resultI2J
                }
            }
            return dp[0][nums.size+1]
        }
    }
}