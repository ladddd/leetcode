package leetcode

//【数组】
class _0349 {
    class Solution {
        // 要求交集中无重复值

        fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
            val map = hashMapOf<Int, Int?>()
            for (num in nums1) {
                map[num] = 1
            }
            for (num in nums2) {
                map[num] = if (map[num] == null) null else 0
            }
            val result = ArrayList<Int>()
            for (key in map.keys) {
                if (map[key] == 0) {
                    result.add(key)
                }
            }
            return result.toIntArray()
        }

        fun intersection2(nums1: IntArray, nums2: IntArray): IntArray {
            if (nums1.isEmpty() || nums2.isEmpty()) {
                return intArrayOf()
            }
            val result = HashSet<Int>()
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