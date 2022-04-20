package leetcode

//【回溯】
class _0078 {

    class Solution {
        fun subsets(nums: IntArray): List<List<Int>> {
            val result = ArrayList<ArrayList<Int>>()
            backtrace(nums, result, arrayListOf(), 0)
            return result
        }

        fun backtrace(nums: IntArray, combinations: ArrayList<ArrayList<Int>>, combination: ArrayList<Int>, index: Int) {
            if (index >= nums.size) {
                combinations.add(ArrayList(combination))
                return
            }
            // 跳过该数字
            backtrace(nums, combinations, combination, index+1)
            // 选择该数字
            combination.add(nums[index])
            backtrace(nums, combinations, combination, index+1)
            // 回撤
            combination.removeAt(combination.size-1)
        }
    }
}