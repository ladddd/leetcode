package leetcode

//【数组】【dp】
class _0096 {

    class Solution {
        fun numTrees(n: Int): Int {
            var result = 0
            val dp = IntArray(n+1)
            dp[0] = 1
            dp[1] = 1
            for (i in 2..n) {
                for (j in 1..i) {
                    // dp(i)= dp(0)*dp(i-1) + dp(1)*dp(i-2) + ... + dp(i-1)dp(0)
                    dp[i] += dp[j-1] * dp[i-j]
                }
            }
            return dp[n]
        }
        // todo 卡塔兰数公式
    }
}