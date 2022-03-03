package leetcode

//【数组】【动态规划】
class _0042: Case {

    override fun exec(args: Array<String>): Array<String> {
        return arrayOf(Solution().trap3(args.map { it.toInt() }.toIntArray()).toString())
    }

    class Solution {
        fun trap(height: IntArray): Int {
            return 0
        }

        // 空间换时间，用两个数组分别保存每一列的"左侧最高"和"右侧最高"
        // 这样，每次找左右两侧最高值的时候就不用遍历一侧所有的元素了
        fun trap3(height: IntArray): Int {
            var result = 0
            val maxLefts = IntArray(height.size) { 0 }
            val maxRights = IntArray(height.size) { 0 }
            // 从左到右遍历一遍, 记录各个位置最高的左侧挡板
            for (i in 1 until height.size-1) {
                maxLefts[i] = if (height[i-1] > maxLefts[i-1]) height[i-1] else maxLefts[i-1]
            }
            // 从右到左遍历一遍，记录各个位置最高的右侧挡板
            for (j in height.size-2 downTo 0) {
                maxRights[j] = if (height[j+1] > maxRights[j+1]) height[j+1] else maxRights[j+1]
            }
            for (index in height.indices) {
                val min = if (maxLefts[index] < maxRights[index]) maxLefts[index] else maxRights[index]
                if (min > height[index]) {
                    result += min - height[index]
                }
            }
            return result
        }

        // 2. 按列求和 （找两侧最高的列，积水取决于"夹板"低的一侧，容量是矮"夹板"和当前列"桶底"的差值）
        fun trap2(height: IntArray): Int {
            var result = 0
            for (index in height.indices) {
                var maxLeft = 0
                // 遍历左侧的列
                for (i in 0 until index) {
                    if (height[i] > maxLeft) {
                        maxLeft = height[i]
                    }
                }
                var maxRight = 0
                // 遍历右侧的列
                for (j in index+1 until height.size) {
                    if (height[j] > maxRight) {
                        maxRight = height[j]
                    }
                }
                // 两侧墙较低的一个和当前位置的差值，是当前位置的积水
                val min = if (maxLeft < maxRight) maxLeft else maxRight
                if (min > height[index]) {
                    result += min - height[index]
                }
            }
            return result
        }

        // 1. 逐层遍历每个高度的积水，按行求和
        fun trap1(height: IntArray): Int {
            var result = 0
            val maxHeight = getMaxHeight(height)
            for (level in 0..maxHeight) {
                var started = false
                var temp = 0 // 每一段积水的量
                for (index in height.indices) {
                    if (height[index] >= level) {
                        started = true
                        result += temp
                        temp = 0
                    } else {
                        // 左边有壁，积水量+1
                        if (started) {
                            temp++
                        }
                    }
                }
            }
            return result
        }

        fun getMaxHeight(height: IntArray): Int {
            var result = 0
            for (h in height) {
                result = if (h > result) h else result
            }
            return result
        }
    }
}