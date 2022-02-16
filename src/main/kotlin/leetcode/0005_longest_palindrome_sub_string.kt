package leetcode

import kotlin.math.max

class _0005: Case {

    override fun exec(args: Array<String>): Array<String> {
        return arrayOf(Solution().longestPalindrome(args.getOrElse(0) { return emptyArray()}))
    }

    class Solution {

        // O(n) = n平方，Manacher算法更为效率( = n)
        fun longestPalindrome(s: String): String {
            var start = 0
            var end = 0
            for (i in s.indices) {
                val oddExpandResult = expand(s, i, i)
                val evenExpandResult = expand(s, i, i+1)
                val result = max(oddExpandResult, evenExpandResult)
                if (result > end - start) {
                    // odd: start = i - l/2, even: start = i + 1/2 - l/2，整数的除法向下取整，所以奇偶都采用 i - (l - 1)/2
                    // odd: end = i + l/2, even: end = i + 1/2 + l/2，整数向下取整 i + l/2
                    start = i - (result - 1)/2
                    end = i + result/2
                }
            }
            return s.substring(start, end+1) // substring
        }

        fun expand(s: String, left: Int, right: Int): Int {
            var l = left
            var r = right
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                // 左右对称时同时向左右延伸
                l--
                r++
            }
            return r - l - 1 // 返回子串长度
        }
    }
}