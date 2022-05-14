package leetcode

//【数组】【排序】
class _0406 {
    class Solution {
        fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
            val result = ArrayList<IntArray>()
            val sorted = people.sortedWith(Comparator { pair1, pair2 ->
                if (pair1[0] != pair2[0]) {
                    // 高度倒序
                    pair2[0] - pair1[0]
                } else {
                    // 前置个数，正序
                    pair1[1] - pair2[1]
                }
            })
            // 排序后插入，因为已在队列中的元素都比当前大，所以插到sorted[i][1],就能保证它(i)之前有sorted[i][1]个高
            for (i in people.indices) {
                result.add(sorted[i][1], sorted[i])
            }
            return result.toTypedArray()
        }
    }
}