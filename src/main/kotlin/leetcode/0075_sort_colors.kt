package leetcode

//【数组】【排序】
class _0075 {

    class Solution {
        fun sortColors(nums: IntArray): Unit {
            var zeroPosition = 0 // 0的边界
            var twoPosition = nums.size - 1 // 2的边界
            var i = 0
            while(i <= twoPosition) { // 遍历完2的边界就停止
                if (nums[i] == 0) {
                    nums[i] = nums[zeroPosition]
                    nums[zeroPosition] = 0
                    zeroPosition++
                }
                // 0、2都独立处理一边
                if (nums[i] == 2) {
                    nums[i] = nums[twoPosition]
                    nums[twoPosition] = 2
                    twoPosition--
                    // 换过来的是0或2都要重新再排
                    if (nums[i] != 1) {
                        i--
                    }
                }
                i++
            }
        }
    }
}