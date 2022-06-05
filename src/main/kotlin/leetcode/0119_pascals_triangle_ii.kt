package leetcode

//【数组】【迭代】
class _0119 {
    class Solution {
        fun getRow2(rowIndex: Int): List<Int> {
            val pre = Array(rowIndex+1) {1}
            val cur = Array(rowIndex+1) {1}
            for (i in 0..rowIndex) {
                for (j in 1 until i) {
                    cur[j] = (pre.getOrNull(j-1)?:0) + (pre.getOrNull(j) ?: 0)
                }
                cur.copyInto(pre, 0, 0, rowIndex)
            }
            return cur.toList()
        }

        // 只用一个数组
        fun getRow(rowIndex: Int): List<Int> {
            val result = Array(rowIndex+1) {1}
            for (i in 0..rowIndex) {
                for (j in i-1 downTo 1) {
                    // 从后向前计算，上一位是未计算过的
                    result[j] += result[j-1]
                }
            }
            return result.toList()
        }

        // todo 组合数公式递推
    }
}