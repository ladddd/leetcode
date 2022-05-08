package leetcode

//【dp】
class _0072: Case {

    override fun exec(args: Array<String>): Array<String> {
        if (args.size < 2) return emptyArray()
        return arrayOf(Solution().minDistance(args[0], args[1]).toString())
    }

    class Solution {
        fun minDistance(word1: String, word2: String): Int {
            // dp[i][j] word1 substring(0,i)变到word2 substring(0,j)的最短距离
            val dp = Array(word1.length+1) { Array(word2.length+1) {0} }
            // word1[i] == word2[j], 不需要任何操作，dp[i][j]==dp[i-1][j-1]
            // word2[i] != word2[j] 需要三种可能操作中的一种，dp[i][j] = min(dp[i-1][j-1] // 替换, dp[i-1][j] // 删除， dp[i][j-1] // 插入) + 1
            // 初始化第一行，第一列
            for (i in 1 .. word1.length) {
                // 0 - word1.length-1
                dp[i][0] = dp[i-1][0] + 1
            }
            for (j in 1 ..  word2.length) {
                // 0 - word2.length-1
                dp[0][j] = dp[0][j-1] + 1
            }
            for (i in 1 .. word1.length) {
                for (j in 1 .. word2.length) {
                    if (word1[i-1] == word2[j-1]) {
                        dp[i][j] = dp[i-1][j-1]
                    } else {
                        dp[i][j] = minOf(
                            dp[i-1][j-1],
                            dp[i-1][j],
                            dp[i][j-1]
                        ) + 1
                    }
                }
            }
            return dp[word1.length][word2.length]
        }
    }
}