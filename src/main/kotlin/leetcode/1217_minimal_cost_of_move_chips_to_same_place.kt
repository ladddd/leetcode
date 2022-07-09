package leetcode

//【数组】【贪心】
class _1217 {
    // 移动筹码，奇数间隔cost1，偶数间隔cost0

    class Solution {
        fun minCostToMoveChips(position: IntArray): Int {
            var odd = 0 // 全部移动到奇树位置的cost
            var even = 0 // 全部移动到偶数位置的cost
            for (pos in position) {
                if (pos%2 == 1) {
                    // 奇数到奇数0, 奇数到偶数1，even++
                    even++
                } else {
                    odd++
                }
            }
            return minOf(odd, even)
        }
    }
}