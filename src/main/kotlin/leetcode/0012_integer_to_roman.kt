package leetcode

//【字符串】
class _0012 {
    class Solution {
        fun intToRoman(num: Int): String {
            val result = StringBuilder()
            // 字符-值 表，模拟
            val values = arrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
            val symbols = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
            var temp = num
            for (i in values.indices) {
                val value = values[i]
                val symbol = symbols[i]
                while (temp >= value) {
                    temp -= value
                    result.append(symbol)
                }
                if (temp == 0) {
                    break
                }
            }
            return result.toString()
        }
    }
}