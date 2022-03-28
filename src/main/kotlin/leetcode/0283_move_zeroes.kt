package leetcode

//【数组】
class _0283 {

    class Solution {
        fun moveZeroes(nums: IntArray): Unit {
            var i = 0
            var j = 0
            while (i < nums.size) {
                // i找不为0的数，换到右边
                // j记录非0数的边界（左侧非0），非0值插入的位置
                if (nums[i] != 0) {
                    val temp = nums[i]
                    nums[i] = nums[j]
                    nums[j] = temp
                    j++
                }
                i++
            }
        }
    }
}