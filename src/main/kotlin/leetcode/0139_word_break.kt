package leetcode

//【dp】
class _0139 {

    class Solution {
        // dp 方程
        // dp(i) = dp(j)*check(s[j, i-1]) j<i
        // 如果前j个字母能在被分割，只需要再检测j - i-1部分
        // down - top
        fun wordBreak(s: String, wordDict: List<String>): Boolean {
            val dp = Array<Boolean>(s.length+1) { index -> index==0 }
            for (i in 0..s.length) {
                //todo i - j这个区间可以优化到字典最大字符长度， 防止一直往下找
                for (j in 0 until i) {
                    if (dp[j] && wordDict.contains(s.substring(j, i))) {
                        dp[i] = true
                        break
                    }
                }
            }
            return dp[s.length]
        }
    }
}