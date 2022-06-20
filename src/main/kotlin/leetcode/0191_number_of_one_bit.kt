package leetcode

//【位运算】
class _0191 {
    class Solution {
        // you need treat n as an unsigned value
        fun hammingWeight2(n:Int):Int {
            var result = 0
            for (i in 0 until 32) {
                if (n and (1 shl i) != 0) {
                    result++
                }
            }
            return result
        }

        // n & (n-1) 消bits串中最后的1
        fun hammingWeight(n:Int):Int {
            var result = 0
            var num = n
            while (num != 0) {
                num = num and (num - 1)
                result++
            }
            return result
        }
    }
}