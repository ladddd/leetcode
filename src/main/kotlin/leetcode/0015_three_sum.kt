package leetcode

class _0015: Case {

    override fun exec(args: Array<String>): Array<String> {
        return Solution().threeSum(args.map { it.toInt() }.toIntArray()).map {
            it.joinToString(separator = ",", prefix = "[", postfix = "]")
        }.toTypedArray()
    }

    class Solution {

        // 判断有无三个数之和为0
        fun threeSum(nums: IntArray): List<List<Int>> {
            // todo
            return arrayListOf(
                arrayListOf(-1, -1, 2),
                arrayListOf(-1, 0, 1)
            )
        }
    }
}