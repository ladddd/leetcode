package leetcode

//【数组】【二分】
class _0034 {

    // 二分查找左右区间逼近变式
    // todo 普通二分后再向前、向后查找边界
    class Solution {

        fun searchRange(nums: IntArray, target: Int): IntArray {
            // 二分查找左侧逼近和右侧逼近
            val result = intArrayOf(-1, -1)
            if (nums.isEmpty()) return result
            var left = 0
            var right = nums.size - 1
            // * 二分查找变式一，向右逼近找左侧边界
            while (left < right) {
                // 查找左侧边界
                val mid = (left+right)/2 // 向下取整，所以让left=mid+1
                if (nums[mid] >= target) {
                    right = mid
                } else {
                    left = mid+1
                }
            }
            if (nums[left] != target) return result
            result[0] = left
            left = 0
            right = nums.size - 1
            // * 二分查找变式二，向左逼近找右侧边界
            while (left < right) {
                // 查找右侧边界
                val mid = (left+right+1)/2 // +1可以向上取整，所以让right = mid - 1
                if (nums[mid] <= target) {
                    left = mid
                } else {
                    right = mid-1
                }
            }
            result[1] = left

            return result
        }
    }
}