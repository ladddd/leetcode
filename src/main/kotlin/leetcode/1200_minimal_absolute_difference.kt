package leetcode

class _1200 {
    class Solution {
        fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
            val result = ArrayList<ArrayList<Int>>()
            if (arr.isNotEmpty()) {
                var minDiff = Int.MAX_VALUE
                val sortedArr = arr.sorted()
                for (i in 1 until sortedArr.size) {
                    val diff = sortedArr[i] - sortedArr[i-1]
                    if (diff > minDiff) {
                        continue
                    }
                    if (diff < minDiff) {
                        result.clear()
                        minDiff = diff
                    }
                    result.add(arrayListOf(sortedArr[i-1], sortedArr[i]))
                }
            }
            return result
        }
    }
}