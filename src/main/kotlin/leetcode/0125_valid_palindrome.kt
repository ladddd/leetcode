package leetcode

//【数组】【字符串】
class _0125: Case {

    override fun exec(args: Array<String>): Array<String> {
        return arrayOf(Solution().isPalindrome(args[0]).toString())
    }

    class Solution {
        fun isPalindrome(s: String): Boolean {
            var low = 0
            var high = s.length - 1
            while (low <= high) {
                if (s[low] !in 'a'..'z' && s[low] !in 'A'..'Z' && s[low] !in '0'..'9') {
                    low++
                } else if (s[high] !in 'a'..'z' && s[high] !in 'A'..'Z' && s[high] !in '0'..'9') {
                    high--
                } else {
                    if (s[low].toLowerCase() != s[high].toLowerCase()) {
                        return false
                    }
                    low++
                    high--
                }
            }
            return true
        }
    }
}