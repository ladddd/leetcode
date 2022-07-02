package leetcode

//【位运算】
class _0231 {

    // 是否是2的幂
    class Solution {
        fun isPowerOfTwo2(n: Int): Boolean {
            return n != 0 && (n and (n-1) == 0) // 判断是否是2的幂最好的方式
        }

        fun isPowerOfTwo(n: Int): Boolean {
            if (n <= 0) return false
            var oneCount = 0
            for (i in 1..32) {
                val bit = (n shr i) and 1
                oneCount += bit
                if (oneCount > 1) {
                    break
                }
            }
            return oneCount == 1
        }

    }
}