package leetcode

//【dp】
class _0152: Case {

    override fun exec(args: Array<String>): Array<String> {
        return arrayOf(Solution().maxProduct(args[0].split(",").map { it.toInt() }.toIntArray()).toString())
    }

    class Solution {
        // 最大连续乘积
        fun maxProduct(nums: IntArray): Int {
            if (nums.isEmpty()) return 0
            var maxOfPeriod = nums[0] // 连续最大正值
            var minOfPeriod = nums[0]
            var result = nums[0]
            for (i in 1 until nums.size) {
                val currentMax = maxOfPeriod
                val currentMin = minOfPeriod
                maxOfPeriod = maxOf(nums[i], currentMax * nums[i], currentMin * nums[i])
                minOfPeriod = minOf(nums[i], currentMax * nums[i], currentMin * nums[i])
                result = maxOf(result, maxOfPeriod)
            }
            return result
        }
    }
}