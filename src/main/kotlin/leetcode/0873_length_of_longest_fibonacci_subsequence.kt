package leetcode

//【数组】【dp】
class _0873 {
    // 最长斐波那契子序列，序列dp
    // arr严格递增 *正整数*
    class Solution {
        fun lenLongestFibSubseq(arr: IntArray): Int {
            // f[i][j] 为i为arr最后一位，j为arr倒数第二位的斐波那契数列
            // 知道为后一位，即可递推出整个数列
            var result = 0

            // 用一个hashmap保存值的下标，这样不用每次都遍历
            val map = hashMapOf<Int, Int>()
            for (i in arr.indices) {
                map[arr[i]] = i
            }

            // 开辟一块 size * size 的空间记录状态
            val size = arr.size
            val dp = Array(size) { Array(size) {0} }
            for (i in 0 until size) {
                for (j in size-1 downTo 0) {
                    // 剪枝
                    if (arr[i] - arr[j] >= arr[j]) break
                    val t = map.getOrDefault(arr[i] - arr[j], -1) // 倒数第三位的下标
                    if (t >= 0) {
                        // ... - t - j - i
                        dp[i][j] = maxOf(3, dp[j][t] + 1)
                        result = maxOf(result, dp[i][j])
                    }
                }
            }
            return result
        }
    }
}