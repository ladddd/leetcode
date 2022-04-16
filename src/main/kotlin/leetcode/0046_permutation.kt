package leetcode

//【回溯】
class _0046 {

    // 全排列
    // 这里回撤的是使用过数字的下标
    class Solution {
        fun permute(nums: IntArray): List<List<Int>> {
            val result = ArrayList<ArrayList<Int>>()
            if (nums.isNotEmpty()) {
                val visited = Array(nums.size) { false }
                backtrace(nums, visited, result, arrayListOf())
            }
            return result
        }

        fun backtrace(nums: IntArray, visited: Array<Boolean>, combinations: ArrayList<ArrayList<Int>>, combination: ArrayList<Int>) {
            if (combination.size >= nums.size) {
                combinations.add(ArrayList(combination))
                return
            } else {
                for (i in nums.indices) {
                    // 从未选过的数字中挑选一个
                    if (!visited[i]) {
                        combination.add(nums[i])
                        visited[i] = true
                        backtrace(nums, visited, combinations, combination)
                        visited[i] = false
                        combination.removeAt(combination.size-1)
                    }
                }
            }
        }
    }
}