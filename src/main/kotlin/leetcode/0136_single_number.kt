package leetcode

//【数组】【位运算】
class _0136: Case {

    override fun exec(args: Array<String>): Array<String> {
        return arrayOf(Solution().singleNumber(args.map { it.toInt() }?.toIntArray()).toString())
    }

    class Solution {

        //朴素用hash表
        fun singleNumber(nums: IntArray): Int {
            val set = HashSet<Int>()
            for (n in nums) {
                if (set.contains(n)) {
                    set.remove(n)
                } else {
                    set.add(n)
                }
            }
            return set.firstOrNull() ?: 0
        }
    }
}