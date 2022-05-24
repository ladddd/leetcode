package leetcode

class _0242 {
    class Solution {
        fun isAnagram(s: String, t: String): Boolean {
            if (s.length != t.length) return false
            val alphabetsS = Array(26) { 0 }
            val alphabetsT = Array(26) { 0 }
            for (i in s.indices) {
                alphabetsS[s[i] - 'a']++
                alphabetsT[t[i] - 'a']++
            }
            for (j in 0 until 26) {
                if (alphabetsS[j] != alphabetsT[j]) {
                    return false
                }
            }
            return true
        }
    }
}