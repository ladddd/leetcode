package leetcode

//【dp】
class _0198 {

    class Solution {

        // dp方程：dp(i) = maxof(dp(i-2) + nums[i], dp(i-1))
        fun rob(nums: IntArray): Int {
            val dp = IntArray(nums.size) {0}
            if (nums.isNotEmpty()) {
                dp[0] = nums[0]
            }
            if (nums.size > 1) {
                dp[1] = maxOf(nums[0], nums[1])
            }
            for (i in 2 until nums.size) {
                dp[i] = maxOf(dp[i-2] + nums[i], dp[i-1])
            }
            return dp[nums.size-1]
        }
    }
}