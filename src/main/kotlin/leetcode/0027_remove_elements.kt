package leetcode
//【数组】【双指针】
class _0027 {

    class Solution {
        // 删除数组内的重复值
        fun removeElement(nums: IntArray, `val`: Int): Int {
            var i = 0
            var j = nums.size
            while (i < j) {
                if (nums[i] == `val`) {
                    // 将val移动到最后，下一次loop再判断交换过来的值
                    nums[i] = nums[j-1]
                    nums[j-1] = `val`
                    j--
                } else {
                    i++
                }
            }
            return i
        }
    }
}