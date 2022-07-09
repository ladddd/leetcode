package leetcode

//【字符串】
class _0205 {

    // 同构字符串
    class Solution {
        fun isIsomorphic(s: String, t: String): Boolean {
            if (s.length != t.length) {
                return false
            }
            val map = hashMapOf<Char, Char>()
            val map2 = hashMapOf<Char, Char>()
            for (i in s.indices) {
                if (map.containsKey(s[i]) || map2.containsKey(t[i])) {
                    if (map[s[i]] != t[i] || map2[t[i]] != s[i]) {
                        return false
                    }
                } else {
                    map[s[i]] = t[i]
                    map2[t[i]] = s[i]
                }
            }
            return true
        }
    }
}