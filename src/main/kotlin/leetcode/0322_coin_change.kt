package leetcode

//【dp】【背包问题】
class _0322 {

    fun exec(coins: IntArray, amount: Int): Int {
        return Solution().coinChange(coins, amount)
    }

    // 硬币凑额度
    class Solution {

        // dp dp[i] = dp[i-coin(j)]+1
        fun coinChange(coins: IntArray, amount: Int): Int {
            val dp = Array(amount+1) { amount+1 }
            dp[0] = 0
            for (i in 1..amount) {
                for (coin in coins) {
                    if (coin <= i) {
                        // 选取最后一次选各种币值之中最小值
                        dp[i] = minOf(dp[i], dp[i-coin] + 1)
                    }
                }
            }
            // *不能用Int.MAX_VALUE做无效值，+1会溢出
            // amount+1是无效值，最终用-1替换，不能初始化为-1，因为求的是最小值
            return if (dp[amount] > amount) -1 else dp[amount]
        }

        fun coinChange2(coins: IntArray, amount: Int): Int {
            return backtrace(coins, ArrayList(), amount)
        }

        // 回溯 O(n)=coins.size^n 会超时
        fun backtrace(coins: IntArray, current: ArrayList<Int>, left: Int): Int {
            if (left == 0) {
                return current.size
            }
            if (left < 0) {
                return -1
            }
            var result = -1
            for (coin in coins) {
                if (coin <= left) {
                    current.add(coin)
                    val cadidate = backtrace(coins, current, left-coin)
                    if (cadidate >= 0) {
                        if (result < 0) {
                            result = cadidate
                        } else {
                            result = minOf(result, cadidate)
                        }
                    }
                    current.removeAt(current.size-1)
                }
            }
            return result
        }
    }

}