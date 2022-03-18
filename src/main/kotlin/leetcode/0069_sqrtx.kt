package leetcode

import kotlin.math.abs

//【迭代】【二分】
class _0069: Case {

    override fun exec(args: Array<String>): Array<String> {
        if (args.isEmpty()) return emptyArray()
        return arrayOf(Solution().mySqrt(args.map { it.toInt() }[0]).toString())
    }

    class Solution {

        // 牛顿迭代法
        // 求 f(x) = xx - C 的正根
        fun mySqrt(x: Int): Int {
            if (x <= 1) return x
            var x0 = x.toDouble() // 以x作为初始值，逼近解
            var result = x0
            while (true) {
                val x1 = (x0 + x / x0) / 2 // 牛顿求根公式
                if (abs(x1 - x0) < 1e-7) { // 浮点数判零
                    result = x0
                    break
                }
                x0 = x1
            }
            return result.toInt()
        }

        // 获取平方根，向下取整
        fun mySqrt2(x: Int): Int {
            if (x <= 1) return x
            var low = 0L
            var high = x.toLong() // 防止Int型溢出
            var result = low
            while (low < high) {
                val mid = (low + high) / 2
                when {
                    mid * mid > x -> {
                        high = mid
                    }
                    mid * mid <= x -> {
                        // 向下取整，所以区间选取上半区间闭合
                        result = mid
                        low = mid + 1
                    }
                }
            }
            return result.toInt()
        }
    }
}