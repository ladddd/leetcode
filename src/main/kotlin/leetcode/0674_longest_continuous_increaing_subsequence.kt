package leetcode

//【数组】【贪心】
class _0674: Case {

    override fun exec(args: Array<String>): Array<String> {
        return arrayOf(Solution().findLengthOfLCIS(args.map { it.toInt() }.toIntArray()).toString())
    }

    class Solution {

        // 贪心 O(n)
        fun findLengthOfLCIS(nums: IntArray): Int {
            if (nums.size < 2) return nums.size
            var result = 1
            var temp = 1
            for (i in 1 until nums.size) {
                if (nums[i] > nums[i-1]) {
                    temp++
                } else {
                    temp=1
                }
                result = if (temp > result) temp else result
            }
            return result
        }

        // todo
        // dp+二分 O(logn)

    }
}