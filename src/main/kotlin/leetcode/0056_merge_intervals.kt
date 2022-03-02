package leetcode

//【数组】
class _0056 {

    fun exec(intervals: Array<IntArray>): Array<IntArray> {
        return Solution().merge(intervals)
    }

    class Solution {
        fun merge(intervals: Array<IntArray>): Array<IntArray> {
            // 排序
            val sorted = intervals.sortedWith(object : Comparator<IntArray> {
                override fun compare(o1: IntArray?, o2: IntArray?): Int {
                    return (o1?.getOrNull(0) ?: 0) - (o2?.getOrNull(0) ?: 0)
                }
            })
            val result = ArrayList<IntArray>()
            result.add(intArrayOf(sorted[0][0], sorted[0][1]))
            for (i in 1 until sorted.size) {
                val left = sorted[i][0]
                val right = sorted[i][1]
                // 比较result的最后一个区间
                if (left > result[result.size - 1][1]) {
                    // 和之前加入的区间没有交集，新增区间
                    result.add(intArrayOf(left, right))
                } else {
                    val originalRight = result[result.size - 1][1]
                    result[result.size - 1][1] = if (right > originalRight) right else originalRight
                }
            }
            return result.toTypedArray()
        }
    }
}