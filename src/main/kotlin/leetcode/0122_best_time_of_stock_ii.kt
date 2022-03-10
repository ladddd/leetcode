package leetcode

import kotlin.math.max

//【DP】【动态规划】【贪心】
class _0122: Case {

    override fun exec(args: Array<String>): Array<String> {
        if (args.isEmpty()) return emptyArray()
        return arrayOf(Solution().maxProfit(args.map { it.toInt() }.toIntArray()).toString())
    }

    // 贪心比较简单
    class Solution {
        // 和121类似，区别是可以在时间周期内重复买卖（*可以当天购买和卖出）

        // 贪心，累加所有正值的波段
        fun maxProfit(prices: IntArray): Int {
            if (prices.size < 2) return 0
            var result = 0
            for (i in 1 until prices.size) {
                val profit = prices[i] - prices[i-1]
                if (profit > 0) {
                    result += profit
                }
            }
            return result
        }

        // dp
        fun maxProfit2(prices: IntArray): Int {
            // dp[period][money] stock=0 持有股票时的现金, stock=1 未持有股票时的现金
            val dp = Array<Array<Int>>(prices.size) { Array(2) { 0 } }
            // 初始化第一天的场景 dp[0]
            // 此处二维数据可以用滚动变量将空间复杂度从O(n)优化到O(1)
            dp[0][0] = -prices[0] // 第一天开始持有，负的现金
            dp[0][1] = 0 // 第一天未持有
            for (i in 1 until prices.size) {
                // 相比121，这里因为是多段的所以用前一天的持仓价值减去今天的价格
                dp[i][0] = max(dp[i-1][1]-prices[i], dp[i-1][0]) // 如果今天选择持仓，选择*今天买入后剩余现金*或*过去几天现金*更多的现金
                dp[i][1] = max(prices[i]+dp[i-1][0], dp[i-1][1]) // 如果今天选择持币，选择*今天利润*和*之前持币*更高的收益
            }
            return dp[prices.size - 1][1]
        }
    }
}