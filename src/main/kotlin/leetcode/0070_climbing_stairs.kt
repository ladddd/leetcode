package leetcode

//【数组】【dp】【斐波那契】
class _0070: Case {

    override fun exec(args: Array<String>): Array<String> {
        return arrayOf(Solution().climbStairs(args.getOrNull(0)?.toInt() ?: 0).toString())
    }

    class Solution {

        // 递推公式
        // f(x) = f(x-1) + f(x-2)
        fun climbStairs(n: Int): Int {
//            val dp = IntArray(n){ 0 }
//            dp[0] = 1
//            for (i in 1 until n) {
//                dp[i] = dp[i-1] + (dp.getOrNull(i-2) ?: 1)
//            }
//            return dp.last()
            // 使用滚动变量代替dp数组
            var p1 = 0
            var p2 = 0
            var result = 1 // n = 1
            for (i in 1 .. n) {
                p1 = p2
                p2 = result
                result = p1 + p2
            }
            return result
        }
    }
}