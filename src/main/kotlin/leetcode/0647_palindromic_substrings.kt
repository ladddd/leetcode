package leetcode

//【数组】
class _0647 {
    // 统计回文子串个数
    class Solution {

        // 中央爆破，两种场景，中心是1位或2位
        fun countSubstrings(s: String): Int {
            var result = 0
            for (i in s.indices) {
                for (j in 0..1) {
                    var left = i
                    var right = left + j
                    while (left >= 0 && right < s.length && s[left] == s[right]) {
                        result++
                        left--
                        right++
                    }
                }
            }
            return result
        }
    }
}