package leetcode

//【数组】【递归】【Hash】【动态规划】
class _0128: Case {

    override fun exec(args: Array<String>): Array<String> {
        return arrayOf(Solution().longestConsecutive(args.map { it.toInt() }.toIntArray()).toString())
    }

    class Solution {

        // 使用hashset存放所有元素，方便查找
        fun longestConsecutive2(nums: IntArray): Int {
            var result = 0
            val set = hashSetOf(*nums.toTypedArray())
            for (i in nums.indices) {
                // 小1的数不在集合中，能作为连续串的开头
                if (!set.contains(nums[i] - 1)) {
                    var count = 1
                    var current = nums[i]
                    while (set.contains(++current)) {
                        count++
                    }
                    result = if (count > result) count else result
                }

            }
            return result
        }

        // 使用一个hashmap存放每个元素 *包含它的连续区间的长度*
        // O(n) = n
        fun longestConsecutive(nums: IntArray): Int {
            var result = 0
            val hashMap = hashMapOf<Int, Int>()
            for (num in nums) {
                if (hashMap.containsKey(num)) {
                    continue
                }
                val left = hashMap[num - 1] ?: 0 // 小1的数最大连续区间
                val right = hashMap[num + 1] ?: 0 // 大1的数最大连续区间
                val current = left + right + 1
                result = if (current > result) current else result
                hashMap[num] = -1 // 将当前数子存入map，防止重复统计
                hashMap[num - left] = current
                hashMap[num + right] = current
            }
            return result
        }
    }
}