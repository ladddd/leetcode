package leetcode

//【数组】【排序】
class _0268 {
    class Solution {
        fun missingNumber(nums: IntArray): Int {
            // 排序再查找下标和值不一致的即可 下标是应该出现的missing number
            // * 缺最后一个的情况
            val sorted = nums.sorted()
            for (i in sorted.indices) {
                if (i != sorted[i]) {
                    return i
                }
            }
            return nums.size
        }
    }
}