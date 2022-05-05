package leetcode

//【dp】
class _0309 {

    // 含冷冻期的最佳股票买卖时间
    class Solution {

        // 和122类似，但不能卖了隔天就买（贪心收集所有波段不可行？）
        fun maxProfit(prices: IntArray): Int {
            // dp[day][money] = profit money=0: 持有股票，money=1: 持有现金, 可买入；money=2: 持有现金，cd中不可买
            val dp = Array(prices.size) { Array(3) { 0 } }
            dp[0][0] = -prices[0] // 持仓
            for (i in 1 until prices.size) {
                dp[i][0] = maxOf(dp[i-1][0], dp[i-1][1]-prices[i])
                dp[i][1] = maxOf(dp[i-1][2], dp[i-1][1]) //*可买入不一定是昨天卖的, 比较前一天空仓的两个状态
                dp[i][2] = dp[i-1][0]+prices[i]
            }
            // todo 因为只关注前一天的3个状态，可以用3个滚动变量优化空间
            return maxOf(dp[prices.size-1][1], dp[prices.size-1][2])
        }
    }
}