package leetcode

class _0014: Case {

    override fun exec(args: Array<String>): Array<String> {
        val solution = Solution()
        return arrayOf(solution.longestCommonPrefix(args))
    }

    class Solution {

        // O(n) = mn 字符串平均长度 * 数量
        fun longestCommonPrefix(strs: Array<String>): String {
            if (strs.isEmpty()) {
                return ""
            }
            // 将字符串数据排序后只需要比较第一个和最后一个
            // strs.sorted()

            // 最长前缀不会超出首个串的长度
            for (i in 0 until strs[0].length) {
                for (j in 1 until strs.size) {
                    // 1.达到某个子串的最大长度，或者该列出现不相同的字符
                    if (strs[j].length == i || strs[j][i] != strs[j-1][i]) {
                        return strs[0].substring(0, i)
                    }
                }
            }

            return strs[0]
        }
    }
}