package leetcode

//【数组】
class _0011 {

    class Solution {
        fun maxArea(height: IntArray): Int {
            var i = 0
            var j = height.size - 1
            var max = 0
            while (i < j) {
                val water = (j - i) * minOf(height[i], height[j])
                max = maxOf(max, water)
                if (height[i] < height[j]) {
                    i++
                } else {
                    j--
                }
            }
            return max
        }
    }
}