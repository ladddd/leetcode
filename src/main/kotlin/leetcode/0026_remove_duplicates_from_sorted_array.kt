package leetcode

//【数组】【双指针】
class _0026 {

    // 原地修改数组，返回非重复部分截止的下标
    class Solution {
        fun removeDuplicates(nums: IntArray): Int {
            if (nums.isEmpty()) return 0
            var i = 1 // 右边界，j != j-1时更新
            var j = 1
            while (j < nums.size) {
                if (nums[j] != nums[j-1]) {
                    nums[i] = nums[j]
                    i++
                }
                j++
            }
            return i
        }
    }
}