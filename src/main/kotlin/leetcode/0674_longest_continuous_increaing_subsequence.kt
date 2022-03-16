package leetcode

//【数组】【贪心】
class _0674: Case {

    override fun exec(args: Array<String>): Array<String> {
        return arrayOf(Solution().findLengthOfLCIS(args.map { it.toInt() }.toIntArray()).toString())
    }

    class Solution {

        // 贪心 O(n)
        fun findLengthOfLCIS(nums: IntArray): Int {
            if (nums.size < 2) return nums.size
            var result = 1
            var temp = 1
            for (i in 1 until nums.size) {
                if (nums[i] > nums[i-1]) {
                    temp++
                } else {
                    temp=1
                }
                result = if (temp > result) temp else result
            }
            return result
        }

        // *延伸* 输出最长递增子序列序列
        // dp+二分 O(nlogn)
        fun findLCIS(nums: IntArray): IntArray {
            if (nums.isEmpty()) return intArrayOf()
            val sorted = nums.sortedArray()
            val result = ArrayList<Int>()
            result.add(nums[0])
            for (i in 1 until sorted.size) {
                var low = 0
                var high = result.size - 1
                while (low <= high) {
                    val mid = (low + high) / 2
                    if (result[mid] < sorted[i]) {
                        low = mid + 1
                    } else {
                        high = mid
                    }
                }
                if (low >= result.size) {
                    result.add(nums[low])
                } else {
                    result[low] = nums[low]
                }
            }
            return result.toIntArray()
        }

    }
}