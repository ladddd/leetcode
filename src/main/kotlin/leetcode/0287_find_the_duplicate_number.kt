package leetcode

//【数组】【二分搜索】【链表】
class _0287 {
    // n+1个数，[1, n]范围内，有一个数重复
    class Solution {

        // 方法一：想象为链表，寻找重复即环的检测
        // 采用快慢指针法检测环
        // 模拟的链表head是下标0，nums[0]表示下一个元素的下标
        fun findDuplicate(nums: IntArray): Int {
            var slow = 0
            var fast = 0
            // 确定有环
            do {
                slow = nums[slow]
                fast = nums[nums[fast]]
            } while (slow != fast)
            // 此时从0到环入口和slow到环入口的步数相同
            var result = 0
            while (result != slow) {
                result = nums[result]
                slow = nums[slow]
            }
            return result
        }
    }
}