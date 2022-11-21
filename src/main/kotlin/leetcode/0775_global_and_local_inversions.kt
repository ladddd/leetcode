package leetcode

import kotlin.math.abs

//【数组】
class _0775: Case {

    override fun exec(args: Array<String>): Array<String> {
        return arrayOf(Solution().isIdealPermutation(args[0].split(",").map { it.toInt() }.toIntArray()).toString())
    }

    // 0 - n-1 的排列
    // 全局倒置：满足 0 <= i < j < n，nums[i] > nums[j]
    // 局部倒置：满足 0 <= i < n - 1，nums[i] > nums[i+1]
    class Solution {

        // 前缀最大值
        // 全局倒置数量 > 局部倒置数量
        fun isIdealPermutation(nums: IntArray): Boolean {
            for (i in nums.indices) {
                if (abs(nums[i] - i) >= 2) {
                    return false
                }
            }
            return true
        }

        // 数学 树状数组
        fun isIdealPermutation3(nums: IntArray): Boolean {
            // todo
            return true
        }

        // 暴力 会超时
        fun isIdealPermutation2(nums: IntArray): Boolean {

            var globalInversionCount = 0
            var localInversionCount = 0
            for (i in 0..nums.size-2) {
                for (j in i+1 until nums.size) {
                    if (nums[j] > nums[i]) {
                        continue
                    }
                    if (j == i+1) {
                        localInversionCount++
                    }
                    globalInversionCount++
                }
            }
            return globalInversionCount == localInversionCount
        }
    }
}