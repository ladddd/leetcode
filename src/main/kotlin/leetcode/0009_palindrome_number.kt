package leetcode

// 数组
class _0009 {

    // 判断回文数
    class Solution {
        fun isPalindrome(x: Int): Boolean {
            val string = x.toString()
            var start = 0
            var end = string.length-1
            while (start < end) {
                if (string[start] == string[end]) {
                   start++
                   end--
                } else {
                    return false
                }
            }
            return true
        }
    }
}