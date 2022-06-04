package leetcode

//【数组】
class _0118 {
    // 杨辉三角
    class Solution {
        fun generate(numRows: Int): List<List<Int>> {
            val result = ArrayList<ArrayList<Int>>(numRows)
            for (i in 0 until numRows) {
                val level = ArrayList<Int>()
                for (j in 0..i) {
                    val value = if (j == 0 || j == i) 1 else
                        (result.getOrNull(i-1)?.getOrNull(j-1) ?: 0) +
                                (result.getOrNull(i-1)?.getOrNull(j) ?: 0)
                    level.add(value)
                }
                result.add(level)
            }
            return result
        }
    }
}