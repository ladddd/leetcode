package leetcode
//【字符串】
class _0058 {
    class Solution {
        fun lengthOfLastWord(s: String): Int {
            var result = 0
            for (i in s.indices.reversed()) {
                if (s[i] == ' ') {
                    if (result == 0) {
                        continue
                    } else {
                        break
                    }
                }
                result++
            }
            return result
        }
    }
}