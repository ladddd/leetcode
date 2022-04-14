package leetcode

//【回溯】
class _0039 {
    // 查询所有可能解，都可以用回溯
    class Solution {
        fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
            val result = arrayListOf<ArrayList<Int>>()
            backtrace(candidates, target, result, arrayListOf(), 0)
            return result
        }

        // 回溯要列出搜索树，对于每一位，可能的选择是跳过或者选择
        // 跳过直接将下标+1；选择则将目标数减去当前位，下标不变
        // todo 先排序candidates可以剪枝
        fun backtrace(candidates: IntArray, target: Int, combinations: ArrayList<ArrayList<Int>>, combination: ArrayList<Int>, index: Int) {
            if (index >= candidates.size) {
                return
            }
            if (target == 0) {
                combinations.add(ArrayList(combination))
                return
            }
            // 第一个分支不选择当前位，直接移动到下一位
            backtrace(candidates, target, combinations, combination, index+1)
            // 第二个分支，条件允许的话选择当前数
            if (target - candidates[index] >= 0) {
                combination.add(candidates[index])
                backtrace(candidates, target-candidates[index], combinations, combination, index)
                combination.removeAt(combination.size-1)
            }
        }
    }
}