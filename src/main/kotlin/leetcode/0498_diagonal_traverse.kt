package leetcode

import kotlin.math.abs

class _0498 {
    class Solution {
        fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
            val width = mat.size
            val height = mat[0].size
            val result = ArrayList<Int>()
            // width + height - 1 对角线条数
            for (i in 0 until width + height - 1) {
                if (i % 2 == 1) { // 奇数条对角线是从纵坐标上发射的
                    // 横坐标由小到大
                    var x = if (i < height) 0 else i - height + 1
                    var y = if (i < height) i else height - 1
                    while (x < width && y >= 0) {
                        result.add(mat[x][y])
                        x++
                        y--
                    }
                } else {
                    var x = if (i < width) i else width - 1
                    var y = if (i < width) 0 else i - width + 1
                    while (x >= 0 && y < height) {
                        result.add(mat[x][y])
                        x--
                        y++
                    }
                }
            }
            return result.toIntArray()
        }
    }
}