package leetcode

//【数组】【环】
class _0202 {
    // 快乐数，各位的平方和相加，重复数次，能使结果为1的，即是快乐数。另一种情况是*无限循环*
    class Solution {
        fun isHappy(n: Int): Boolean {
            var slow = n
            var fast = n
            do {
                slow = bitSquareSum(slow)
                fast = bitSquareSum(fast)
                fast = bitSquareSum(fast)
            } while (slow != fast) // 无限循环代表有环，用快慢指针检测
            return slow == 1
        }

        fun bitSquareSum(num: Int): Int {
            var rest = num
            var sum = 0
            while (rest > 0) {
                // 最低位开始累加各位平方和
                sum += (rest%10) * (rest%10)
                rest /= 10
            }
            return sum
        }

        // todo 还可以用hashmap统计平方和出现的次数来判断是否有环
    }
}