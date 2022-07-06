package leetcode

//【数组】
class _0556 {

    // 同 31的下一个排列
    class Solution {
        fun nextGreaterElement(n: Int): Int {
            val array = n.toString().map { it - '0'}.toTypedArray()
            var targetIndex = -1
            for (i in array.indices.reversed()) {
                if (array[i] < (array.getOrNull(i+1) ?: Int.MIN_VALUE)) {
                    targetIndex = i
                    break
                }
            }
            if (targetIndex == -1) return -1
            var swapIndex = targetIndex
            var swapValue = Int.MAX_VALUE
            for (j in targetIndex+1 until array.size) {
                // 在targetIndex之后找出比array[targetIndex]略大的值
                if (array[j] > array[targetIndex] && array[j] < swapValue) {
                    swapIndex = j
                    swapValue = array[j]
                }
            }
            if (swapIndex != targetIndex) {
                val temp = array[targetIndex]
                array[targetIndex] = array[swapIndex]
                array[swapIndex] = temp
            }
            array.sort(targetIndex+1, array.size)
            // array to int
            return array.joinToString(separator = "").toIntOrNull() ?: -1
        }
    }
}