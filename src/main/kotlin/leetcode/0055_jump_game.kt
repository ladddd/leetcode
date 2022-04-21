package leetcode

//【贪心】
class _0055 {

    class Solution {
        // 遍历每个节点，维护最远可达距离
        // [0] 算成可以到
        fun canJump(nums: IntArray): Boolean {
            var furthest = 0
            for (index in nums.indices) {
                // 如果目标在最大距离外了，就停止
                if (index > furthest) {
                    return false
                }
                furthest = maxOf(furthest, nums[index] + index)
            }
            return true
        }
    }
}