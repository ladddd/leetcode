package leetcode

//【数组】
class _0532: Case {

    override fun exec(args: Array<String>): Array<String> {
        return arrayOf(Solution().findPairs(args[0].split(",").map { it.toInt() }.toIntArray(), args[1].toInt()).toString())
    }

    class Solution {
        // 双指针遍历
        // *也可以用hash表做结果数对的去重
        // *不排序的话用二分查找搜索 low - high 区间中差值为k的数的下标
        fun findPairs(nums: IntArray, k: Int): Int {
            val sorted = nums.sortedDescending()
            var result = 0
            // 满足以下条件的数对：
            // i < j
            // sorted[i] + k == sorted[j]
            for (i in sorted.indices) {
                // 防止i重复
                if (sorted[i] == sorted.getOrNull(i-1)) {
                    continue
                }
                var j = sorted.size - 1
                while (i < j && sorted[i] - sorted[j] >= k) {
                    // 差值为k，且第j个和第j+1个值不相同，防止重复计算
                    if (sorted[i] - sorted[j] == k && sorted[j] != sorted.getOrNull(j+1)) {
                        result++
                    }
                    j--
                }
            }
            return result
        }
    }
}