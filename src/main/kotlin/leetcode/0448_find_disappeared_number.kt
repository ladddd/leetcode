package leetcode

class _0448 {

    // n个整数 找出1-n中不存在的整数
    class Solution {

        fun findDisappearedNumbers(nums: IntArray): List<Int> {
            val result = arrayListOf<Int>()
            // 第一遍遍历，给出现过的数字+size
            for (i in nums.indices) {
                val index = (nums[i]-1) % nums.size // i=0, nums[0]=3, 给3顺序排列的下标2位置的值+size
                nums[index] += nums.size
            }
            for (j in nums.indices) {
                if (nums[j] <= nums.size) {
                    result.add(j+1)
                }
            }
            return result
        }
    }
}