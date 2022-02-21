package leetcode

// 【双指针】
class _0015: Case {

    override fun exec(args: Array<String>): Array<String> {
        return Solution().threeSum(args.map { it.toInt() }.toIntArray()).map {
            it.joinToString(separator = ",", prefix = "[", postfix = "]")
        }.toTypedArray()
    }

    class Solution {

        // 判断有无三个数之和为0
        fun threeSum(nums: IntArray): List<List<Int>> {
            val results = ArrayList<List<Int>>()
            nums.sort()
            for (first in 0..nums.size - 3) {
                if (nums[first] > 0) break
                if (first > 0 && nums[first - 1] == nums[first]) continue // first和上一个数字相同，跳过
                val firstNum = nums[first]
                var third = nums.size - 1
                var second = first + 1
                // 内部两层嵌套可变为双指针
                while (second < third) {
                    val sum = firstNum + nums[second] + nums[third]
                    when {
                        sum == 0 -> {
                            results.add(arrayListOf(firstNum, nums[second], nums[third]))
                            second++
                            third--
                            // 这边左右指针要去找最近一个不同的数字，防止找到重复的组合
                            while (second < third && nums[second] == nums[second - 1]) second++
                            while (second < third && nums[third] == nums[third + 1]) third--
                        }
                        sum < 0 -> second++
                        sum > 0 -> third--
                    }
                }
            }
            return results
        }
    }
}