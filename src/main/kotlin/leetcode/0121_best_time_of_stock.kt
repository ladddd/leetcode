package leetcode

//【DP】【动态规划】
class _0121: Case {

    override fun exec(args: Array<String>): Array<String> {
        if (args.isEmpty()) return emptyArray()
        return arrayOf(Solution().maxProfit(args.map { it.toInt() }.toIntArray()).toString())
    }

    class Solution {

        // 将问题拆解为两个小问题，何时买，何时卖
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
    }
}