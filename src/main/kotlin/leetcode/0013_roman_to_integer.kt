package leetcode

class _0013 {
    class Solution {
        fun romanToInt(s: String): Int {
            if (s.isEmpty()) return 0
            var result = 0
            var pre = getValue(s[0])
            // 从第二位开始，每一步累加前一位的值，比当前位大加，比当前位小减
            // 题目保证罗马计数书写正确，不出现跨位现象
            for (i in 1 until s.length) {
                val now = getValue(s[i])
                if (now > pre) {
                    result -= pre
                } else {
                    result += pre
                }
                pre = now
            }
            result += pre
            return result
        }

        fun getValue(char: Char): Int {
            return when(char) {
                'I' -> 1
                'V' -> 5
                'X' -> 10
                'L' -> 50
                'C' -> 100
                'D' -> 500
                'M' -> 1000
                else -> 0
            }
        }
    }
}