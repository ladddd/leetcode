package leetcode

//【dp】【动态规划】
class _0338: Case {

    override fun exec(args: Array<String>): Array<String> {
        if (args.isEmpty()) return emptyArray()
        return Solution().countBits(args[0].toInt()).map { it.toString() }.toTypedArray()
    }

    // 0-n 二进制计数中1的个数
    class Solution {

        // 最高有效位
        // 通过加最高位的1，形成递归方程
        fun countBits(n: Int): IntArray {
            val result = IntArray(n+1) { 0 }
            var highBit = 0
            for (i in 1..n) {
                // highBit 是最靠近i的，首位为1，其余全0的数
                // 更新highBit
                highBit = if (i % 2 == 0) i else highBit
                // i - highBit 一定是之前计算过的值
                result[i] = result[i - highBit] + 1
            }
            return result
        }
    }
}