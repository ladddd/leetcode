package leetcode

//【数组】【二分搜索】
class _0035 {
    class Solution {
        fun searchInsert(nums: IntArray, target: Int): Int {
            var low = 0
            var high = nums.size - 1
            while (low <= high) { // 二分结束条件，=
                val mid = (low + high) / 2
                if (nums[mid] == target) {
                    return mid
                } else if (nums[mid] < target) {
                    low = mid + 1
                } else {
                    high = mid - 1
                }
            }
            return low
        }
    }
}