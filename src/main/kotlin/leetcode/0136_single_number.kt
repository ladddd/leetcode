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

        // 使用位运算，两个相同数字做异或得0: 0 xor n = n; n xor n = 0
        fun singleNumber2(nums: IntArray): Int {
            var result = 0
            for (n in nums) {
                result = result xor n
            }
            return result
        }
    }
}