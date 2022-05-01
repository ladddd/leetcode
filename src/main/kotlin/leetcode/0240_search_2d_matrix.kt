package leetcode

//【数组】【二分】
class _0240 {

    class Solution {

        // 二分查找，逐行
        fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
            val rows = matrix.size
            val cols = matrix[0].size
            for (row in 0 until rows) {
                // 比该行的最大元素还大，转到下一行
                if (matrix[row][cols-1] < target) {
                    continue
                } else if (matrix[row][0] > target) {
                    // 比该行最小元素小，后面都比target大
                    return false
                } else {
                    // 这一行二分查找
                    var lower = 0
                    var upper = cols-1
                    while (lower <= upper) {
                        val mid = (lower + upper)/2
                        if (matrix[row][mid] == target) {
                            return true
                        } else if (matrix[row][mid] < target) {
                            lower = mid + 1
                        } else {
                            upper = mid - 1
                        }
                    }
                }
            }
            return false
        }
    }
}