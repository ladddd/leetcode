package leetcode

class _0066 {
    class Solution {
        fun plusOne(digits: IntArray): IntArray {
            val result = IntArray(digits.size+1) {
                index -> digits.getOrNull(index-1) ?: 0
            }
            var i = digits.size
            var carry = (result[i] + 1) / 10
            result[i] = (result[i] + 1) % 10
            i--
            while (i >= 0) {
                val value = result[i] + carry
                result[i] = value % 10
                carry = value / 10
                i--
            }
            return if (result[0] == 0) {
                IntArray(result.size-1) {
                    result[it + 1]
                }
            } else {
                result
            }
        }

        // +1只需要考虑9的情况
        fun plusOne2(digits: IntArray): IntArray {
            for (i in digits.size-1 downTo 0) {
                digits[i]++ // 加初始的或进位的1
                digits[i] = digits[i] % 10
                // 没有发生进位，直接返回
                if (digits[i] != 0) return digits
            }
            return IntArray(digits.size+1) {
                if (it != 0) 0 else 1
            }
        }
    }
}