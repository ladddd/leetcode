package leetcode

//【dp】
class _0279 {

    class Solution {
        // dp[i] = dp[i-j^2] + 1(j讥为1次)
        fun numSquares(n: Int): Int {
            val dp = Array(n+1) { i -> i } // 最坏的情况需要每次+1
            for (i in 1..n) {
                var j = 1
                while (j*j < i) {
                    dp[i] = minOf(dp[i], dp[i-j*j]+1)
                    j++
                }
            }
            return dp[n]
        }
    }
}