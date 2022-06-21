package leetcode

//【数组】
class _0350 {
    // 数组交集，计算重复元素（349 重复元素记为1个）
    // 把数据格式从set换成arraylist即可
    class Solution {
        fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
            if (nums1.isEmpty() || nums2.isEmpty()) {
                return intArrayOf()
            }
            val result = ArrayList<Int>()
            val small: IntArray
            val big: IntArray
            if (nums1.size < nums2.size) {
                small = nums1
                big = nums2
            } else {
                small = nums2
                big = nums1
            }
            var validSize = big.size
            for (num in small) {
                for (k in 0 until validSize) {
                    if (num == big[k]) {
                        result.add(num)
                        // 逐渐缩小big的选择范围
                        big[k] = big[validSize-1]
                        validSize--
                        break
                    }
                }
            }
            return result.toIntArray()
        }
    }
}