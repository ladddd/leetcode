package leetcode

//【dp】【划动窗口】
class _0053: Case {

    override fun exec(args: Array<String>): Array<String> {
        return arrayOf(Solution().maxSubArray(args.map { it.toInt() }.toIntArray()).toString())
    }

    class Solution {

        // dp
        fun maxSubArray(nums: IntArray): Int {
            if (nums.isEmpty()) return 0
            var result = Int.MIN_VALUE // 最大和
            var sum = 0 // 当前和
            for (num in nums) {
                sum = if (sum > 0)  sum+num else num // 如果之前的和为负值，从这一位开始重新统计
                result = maxOf(result, sum)
            }
            return result
        }
    }
}