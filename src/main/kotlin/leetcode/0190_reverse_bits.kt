package leetcode

//【位运算】
class _0190 {
    class Solution {
        // you need treat n as an unsigned value
        fun reverseBits(n:Int):Int {
            var result = 0
            var index = 0
            var num = n
            while (index in 0 until 32 && num != 0) {
                val bit = (num and 1) shl (31 - index) // num的第0位放到result的第31位，该位左移31-index
                result = result or bit
                num = num shr 1 // 让取num的比特位一直在最后一位
                index++
            }
            return result
        }

        // todo 使用分治思想，二分之后在区间内逆序，直到最细粒度的两个bit位交换
    }
}