package leetcode

//【数组】【字符串】
class _0028 {

    class Solution {
        fun strStr(haystack: String, needle: String): Int {
            var result = -1
            if (haystack.isNotEmpty() && needle.isNotEmpty() && needle.length <= haystack.length) {
                var index = 0
                while (index <= haystack.length - needle.length) {
                    if (haystack[index] != needle[0] || haystack[index+needle.length-1] != needle[needle.length-1]) {
                        index++
                        continue
                    }
                    var match = true
                    for (i in 1 until needle.length-1) {
                        if (haystack[index+i] != needle[i]) {
                            match = false
                            break
                        }
                    }
                    if (match) {
                        result = index
                        break
                    } else {
                        index++
                    }
                }
            }
            return result
        }
    }
}