package leetcode

//【数组】【双指针】
class _0088 {

    // 从后向前插，不需要将插入位置后的串后移一位
    class Solution {
        fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
            var p1 = m - 1 // nums1的有效数据最后一位
            var p2 = n - 1
            var p = m + n - 1
            // 从大到小插
            while (p1 >= 0 || p2 >= 0) {
                val `val` = if (p1 < 0) {
                    nums2[p2--]
                } else if (p2 < 0) {
                    nums1[p1--]
                } else if (nums1[p1] > nums2[p2]) {
                    // 取大的数，然后该数组指针向前移动一位
                    nums1[p1--]
                } else {
                    nums2[p2--]
                }
                nums1[p--] = `val`
            }
        }
    }
}