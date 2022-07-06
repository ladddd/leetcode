package leetcode

//【递归】
class _0258 {
    class Solution {
        fun addDigits(num: Int): Int {
            var n = num
            var result = 0
            while (n != 0) {
                result += n % 10
                n /= 10
            }
            return if (result >= 10) addDigits(result) else result
        }
    }
}