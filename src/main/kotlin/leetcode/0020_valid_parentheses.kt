package leetcode

import java.util.Stack

//【字符串】【栈】
class _0020: Case {

    override fun exec(args: Array<String>): Array<String> {
        if (args.isEmpty()) return emptyArray()
        return arrayOf(Solution().isValid2(args[0]).toString())
    }

    class Solution {

        // 从最内层开始消除成对括号
        fun isValid2(s: String): Boolean {
            var result = s
            while (result.contains("{}") || result.contains("[]") || result.contains("()")) {
                result = result.replace("{}", "")
                result = result.replace("[]", "")
                result = result.replace("()", "")
            }
            return result.isEmpty()
        }

        // 使用栈来判断配对
        fun isValid(s: String): Boolean {
            val stack = Stack<Char>()
            for (char in s) {
                if (char in arrayOf('(','[','{')) {
                    stack.push(char)
                } else {
                    val pair = if (stack.isEmpty()) null else stack.pop()
                    val match = when(char) {
                        ')' -> pair == '('
                        ']' -> pair == '['
                        '}' -> pair == '{'
                        else -> false
                    }
                    if (!match) return false
                }
            }
            return stack.isEmpty()
        }
    }
}