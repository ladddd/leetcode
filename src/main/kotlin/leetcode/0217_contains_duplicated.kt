package leetcode

//【数组】
class _0217 {
    class Solution {
        fun containsDuplicate(nums: IntArray): Boolean {
            val map = hashMapOf<Int, Boolean>()
            for (num in nums) {
                if ((map[num] == true)) {
                    return true
                }
                map[num] = true
            }
            return false
        }
        // 还可以排序后比较相邻两元素
    }
}