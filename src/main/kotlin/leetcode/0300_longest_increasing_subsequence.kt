package leetcode

//【数组】【dp】
class _0300 {
    // 最长子序列，可以不连续
    class Solution {

        // 动态规划，dp[i](序列) = dp[i-1] + nums[i]，再用一个滚动变量维护dp中的最大值
        fun lengthOfLIS(nums: IntArray): Int {
            val dp = Array(nums.size) { 1 }
            var result = 1
            for (i in nums.indices) {
                // 没增加一位，重新计算dp[0]-dp[i]
                for (j in 0..i) {
                    if (nums[i] > nums[j]) {
                        dp[i] = maxOf(dp[i], dp[j])
                    }
                }
                result = maxOf(result, dp[i])
            }
            return result
        }
    }
    // todo 二分+贪心
}