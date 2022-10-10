package leetcode

//【数组】
class _0870 {

    class Solution {
        // 田忌赛马 优势洗牌
        fun advantageCount(nums1: IntArray, nums2: IntArray): IntArray {
            val result = IntArray(nums1.size) {0}

            // 从小到大排列
            // 1.如果nums1中的极小值 > nums2中的极小值，直接配对
            // 2.否则nums1中的极小值和nums2中的极大值配对

            // 用一个hash表记录nums2元素原来的位置
            val map = hashMapOf<Int, ArrayList<Int>>()
            nums2.forEachIndexed { index, num ->
                if (map[num] == null) {
                    map[num] = arrayListOf(index)
                } else {
                    map[num]!!.add(0, index)
                }
            }

            val sorted1 = nums1.sorted()
            val sorted2 = nums2.sorted()

            var l2 = 0
            var r2 = nums2.size-1
            for (i in sorted1.indices) {
                val index = if (sorted1[i] > sorted2[l2]) {
                    map[sorted2[l2++]]?.removeAt(0) ?: continue
                } else {
                    map[sorted2[r2--]]?.removeAt(0) ?: continue
                }
                result[index] = sorted1[i]
            }

            return result
        }
    }
}