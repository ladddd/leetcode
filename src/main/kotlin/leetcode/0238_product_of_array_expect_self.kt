package leetcode

//【数组】【dp】
class _0238 {

    class Solution {
        fun productExceptSelf(nums: IntArray): IntArray {
            val result = IntArray(nums.size) { 1 }
            var left = 1 //左侧总乘积
            var right = 1 // 右侧总乘积
            for (i in 1 until nums.size) {
                left *= nums[i-1]
                right *= nums[nums.size-i]
                result[i] *= left
                result[nums.size-1-i] *= right
            }
            return result
        }
    }
}