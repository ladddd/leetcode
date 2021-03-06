package leetcode

import kotlin.math.max

//【DP】【动态规划】【贪心】
class _0121: Case {

    override fun exec(args: Array<String>): Array<String> {
        if (args.isEmpty()) return emptyArray()
        return arrayOf(Solution().maxProfit2(args.map { it.toInt() }.toIntArray()).toString())
    }

    // 贪心比较简单
    class Solution {

        // 贪心
        // 何时买：找到当天之前的最低价；何时卖：计算当天可能的最大收益
        fun maxProfit(prices: IntArray): Int {
            if (prices.isEmpty()) return 0
            var result = 0 // 下跌趋势，一直不买，最大收益为0
            var lowest = prices[0]
            for (i in prices.indices) {
                if (prices[i] < lowest) {
                    // 遇到最低价，买入
                    lowest = prices[i]
                } else if (prices[i] - lowest > result) {
                    // 更新最大差价
                    result = prices[i] - lowest
                }
            }
            return result
        }

        // dp
        // 用二维数组模拟买卖行为
        fun maxProfit2(prices: IntArray): Int {
            // dp[period][money] stock=0 持有股票时的现金, stock=1 未持有股票时的现金
            val dp = Array<Array<Int>>(prices.size) { Array(2) { 0 } }
            // 初始化第一天的场景 dp[0]
            dp[0][0] = -prices[0] // 第一天开始持有，负的现金
            dp[0][1] = 0 // 第一天未持有
            for (i in 1 until prices.size) {
                dp[i][0] = max(-prices[i], dp[i-1][0]) // 如果今天选择持仓，选择*今天买入价*或*过去几天买入价*更轻的成本
                dp[i][1] = max(prices[i]+dp[i-1][0], dp[i-1][1]) // 如果今天选择持币，选择*今天利润*和*之前持币*更高的收益
            }
            return dp[prices.size - 1][1]
        }
    }
}