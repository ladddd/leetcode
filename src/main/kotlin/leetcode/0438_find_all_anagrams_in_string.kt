package leetcode

//【数组】【滑动窗口】
class _0438 {
    // 求s中p的异位词的数量
    class Solution {
        fun findAnagrams(s: String, p: String): List<Int> {
            val result = ArrayList<Int>()
            if (p.length > s.length) return emptyList()
            // 用两个数组记录s，p在窗口中的字母
            val sAlphabets = Array(26) { 0 }
            val pAlphabets = Array(26) { 0 }

            for (i in p.indices) {
                sAlphabets[s[i] - 'a']++
                pAlphabets[p[i] - 'a']++
            }
            if (sAlphabets.contentEquals(pAlphabets)) {
                result.add(0)
            }
            for (j in 0 until s.length - p.length) {
                // s的字母统计表中去掉第j位字符，增加j+p.length个字符
                sAlphabets[s[j] - 'a']--
                sAlphabets[s[j+p.length] - 'a']++
                if (sAlphabets.contentEquals(pAlphabets)) {
                    // 去掉第j位后相同
                    result.add(j+1)
                }
            }
            return result
        }
    }
}