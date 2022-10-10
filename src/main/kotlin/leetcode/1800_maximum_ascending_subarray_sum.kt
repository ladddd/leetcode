package leetcode

class _1800 {

    class Solution {
        fun maxAscendingSum(nums: IntArray): Int {
            var result = 0
            if (nums.isNotEmpty()) {
                var temp = 0
                for (i in nums.indices) {
                    if (i == 0 || nums[i] > nums[i-1]) {
                        temp += nums[i]
                    } else {
                        temp = nums[i]
                    }
                    result = maxOf(result, temp)
                }
            }

            return result
        }
    }
}