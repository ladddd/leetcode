package leetcode

//【数组】【二分查找】
class _0033 {

    fun exec(nums: IntArray, target: Int): Int {
        return Solution().search(nums, target)
    }

    class Solution {

        // 整数数组 nums 按升序排列，数组中的值 *互不相同*
        // 查询给定值的下标
        // 有序数组，考虑使用二分查找 O(n) = log(n)
        fun search(nums: IntArray, target: Int): Int {
            var left = 0
            var right = nums.size - 1
            while (left <= right) {
                val mid = (left + right) / 2
                if (nums[mid] == target) {
                    return mid
                }
                // mid比位置left的大，前半部分是有序（升序）的
                if (nums[mid] >= nums[left]) {
                    if (nums[mid] > target && target >= nums[left]) {
                        // mid in nums[left]..nums[mid] 这个顺序区间内部，继续查询该区间
                        right = mid - 1
                    } else {
                        left = mid + 1
                    }
                } else {
                    // 后半部分是有序（升序）的
                    if (nums[right] >= target && target > nums[mid]) {
                        left = mid + 1
                    } else {
                        right = mid - 1
                    }
                }
            }
            return -1
        }

    }
}