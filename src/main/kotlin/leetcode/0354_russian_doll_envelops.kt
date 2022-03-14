package leetcode

//【dp】【动态规划】【二分】【贪心】
class _0354 {

    fun exec(args: Array<IntArray>): Int {
        return Solution().maxEnvelopes2(args)
    }

    class Solution {

        // O(NlogN)的做法, 按照长度升序, 同长则宽度降序排列, 然后使用O(logN)的
        // *最长递增子序列*(0674)解法来做。
        fun maxEnvelopes2(envelopes: Array<IntArray>): Int {
            if (envelopes.isEmpty()) return 0
            //先对输入排序，生序，先比较宽度（左半区间）再比较高度（右半区间）
            val sorted = envelopes.sortedArrayWith(Comparator<IntArray> { o1, o2 ->
                if (o1[0] != o2[0]) {
                    o1[0] - o2[0]
                } else {
                    o2[1] - o1[1] // 同宽按高度降序，防止同宽度高度小的进入队列
                }
            })

            // 排序后将问题转化为1维*最长递增子序列*(0674)
            // 模拟套娃
            val result = ArrayList<Int>()
            result.add(sorted[0][1])
            for (i in 1 until sorted.size) {
                var low = 0
                var high = result.size
                // 套娃部分的高度是顺序递增的，可以使用二分来提速
                // 二分遍历 logn，顺序遍历 n
                while (low < high) {
                    val mid = (low + high) / 2
                    if (result[mid] < sorted[i][1]) {
                        low = mid + 1
                    } else {
                        high = mid
                    }
                }
                if (low >= result.size) {
                    // 如果*当前项的高度*比队列中*所有套娃*都大，套在最外面
                    result.add(sorted[i][1])
                } else {
                    // 在现有队列里找到了，说明有同宽的元素，将其替换为高度较小的（宽度升序-高度降序）
                    result[low] = sorted[i][1]
                }
            }
            return result.size
        }

        // 朴素dp
        fun maxEnvelopes(envelopes: Array<IntArray>): Int {
            if (envelopes.isEmpty()) return 0
            //先对输入排序，生序，先比较宽度（左半区间）再比较高度（右半区间）
            val sorted = envelopes.sortedArrayWith(Comparator<IntArray> { o1, o2 ->
                if (o1[0] != o2[0]) {
                    o1[0] - o2[0]
                } else {
                    o1[1] - o2[1]
                }
            })
            val dp = IntArray(envelopes.size) { 1 } // 表示第${index}个信封能套住别的信封的数量
            var result = dp[0]
            for (i in 1 until envelopes.size) {
                // 遍历之前的所有元素（宽度比当前小的）
                for (j in 0 until i) {
                    // 顺序遍历
                    // 同宽度的套不住
                    if (sorted[j][0] == sorted[i][0]) break
                    // 直到高度大于自身的，所以第i个信封能套住的信封数量，是第j个信封能套住数量+1（j本身）
                    if (sorted[j][1] < sorted[i][1]) {
                        dp[i] = maxOf(dp[i], dp[j] + 1)
                    }
                }
                result = maxOf(result, dp[i])
            }

            return result
        }
    }
}