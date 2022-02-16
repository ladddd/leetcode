package leetcode

import java.util.*

//【栈】
class _0071:Case {

    override fun exec(args: Array<String>): Array<String> {
        return arrayOf(Solution().simplifyPath(args[0]))
    }

    class Solution {
        fun simplifyPath(path: String): String {
            val segments = path.split('/')
            val stack = Stack<String>()
            segments.forEach { segment ->
                if (segment == "..") {
                    // 上级目录
                    // 出栈
                    if (stack.isNotEmpty()) {
                        stack.pop()
                    }
                } else if (segment != "." && segment.isNotEmpty()) {
                    // 忽略 "." 同级目录，忽略空字符或空格
                    // 进栈
                    stack.push(segment)
                }
            }
            return stack.joinToString("/", "/")
        }
    }
}