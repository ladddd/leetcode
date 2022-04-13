package leetcode

//【数组】
class _0031 : Case {

    override fun exec(args: Array<String>): Array<String> {
        Solution().nextPermutation(args[0].split(",").map { it.toInt() }.toIntArray())
        return emptyArray()
    }

    class Solution {

        // 如果不存在更大的排列，返回最小的排列（循环）
        fun nextPermutation(nums: IntArray): Unit {
            // 查找下一个大数，且增加的幅度尽可能的小
            // 1.首先从后往前遍历，找到第一个nums[i] < nums[i+1]的数
            // 如 12385764，即5
            // 2.将5和"764"中比它略大的数交换（差值要尽可能的小，才可能是相邻的排列）
            // 得到 12386754
            // 最后将后三位设为升序，即后三位排列出最小的数
            var target = nums.size - 2
            // step 1
            while (true) {
                if (target < 0 || nums[target] < nums[target + 1]) {
                    break
                }
                target--
            }
            // step 2 符合条件的元素则交换
            if (target >= 0) {
                var swap = -1
                var swapValue = Int.MAX_VALUE
                for (i in target + 1 until nums.size) {
                    if (nums[i] > nums[target] && nums[i] < swapValue) {
                        swap = i
                        swapValue = nums[i]
                    }
                }
                if (swap > 0) {
                    val temp = nums[target]
                    nums[target] = nums[swap]
                    nums[swap] = temp
                }
            }
            // step 3 区间升序排序
            nums.sort(target + 1, nums.size)
        }
    }
}