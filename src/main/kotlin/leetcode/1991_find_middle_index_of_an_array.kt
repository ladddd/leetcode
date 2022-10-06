package leetcode

class _1991: Case {
    override fun exec(args: Array<String>): Array<String> {
        return arrayOf(Solution().findMiddleIndex(args.map { it.toInt() }.toIntArray()).toString())
    }

    class Solution {
        fun findMiddleIndex2(nums: IntArray): Int {
            val sum = nums.sum()
            var tempSum = 0
            for (index in nums.indices) {
                if (tempSum * 2 == sum - nums[index]) {
                    return index
                }
                tempSum += nums[index]
            }
            return -1
        }

        // 前缀后缀和
        fun findMiddleIndex(nums: IntArray): Int {
            val prefixSums = Array(nums.size) { 0 }
            val suffixSums = Array(nums.size) { 0 }
            for (i in 1 until nums.size) { prefixSums[i] = prefixSums[i-1] + nums[i-1] }
            for (j in nums.size-2 downTo 0) { suffixSums[j] = suffixSums[j+1] + nums[j+1]}
            println("${prefixSums.toList()} ${suffixSums.toList()}")
            for (k in nums.indices) {
                if (prefixSums[k] == suffixSums[k]) {
                    return k
                }
            }
            return -1
        }
    }
}