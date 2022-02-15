package leetcode

class _0151: Case {

    override fun exec(args: Array<String>): Array<String> {
        val solution = Solution()
        return arrayOf(solution.reverseWords2(args.getOrElse(0) { return emptyArray()}))
    }

    class Solution {

        // 使用String的api
        fun reverseWords(s: String): String {
            return s.split(" ").filter { it.isNotBlank() }.reversed().joinToString(" ")
        }

        // DO NOT USE API
        fun reverseWords2(s: String): String {
            // split
            if (s.isEmpty()) return s
            val words = ArrayList<String>()
            var start = 0
            var end = 0
            do {
                if (s[start] == ' ') {
                    // 该start移动，找到最近的非空字符
                    ++start
                    end = start
                } else {
                    // end 移动, 遇到blank或者串尾
                    if (end == s.length || s[end] == ' ') {
                        words.add(s.substring(start, end))
                        start = end + 1
                    }
                    ++end
                }
            } while (end <= s.length && start < s.length)
            val sb = StringBuffer()
            if (words.isNotEmpty()) {
                for (i in words.size - 1 downTo 0) {
                    sb.append(words[i]).append(" ")
                }
                sb.deleteCharAt(sb.length - 1)
            }
            return sb.toString()
        }
    }
}