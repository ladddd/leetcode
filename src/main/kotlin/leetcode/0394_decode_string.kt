package leetcode

import java.util.Stack

//【栈】
class _0394: Case {

    override fun exec(args: Array<String>): Array<String> {
        if (args.isEmpty()) return emptyArray()
        return arrayOf(Solution().decodeString(args[0]))
    }

    class Solution {
        // k[content] 输入保证是有效的
        // 有嵌套关系 "3[a2[c]]"
        fun decodeString(s: String): String {
            var result = StringBuilder() // 当前层的内容
            // 用两个栈分别记录数量和内容
            val countStack = Stack<Int>()
            val contentStack = Stack<StringBuilder>() // 每一层外部内容
            var tempCount = 0
            for (char in s) {
                when (char) {
                    '[' -> {
                        // 结算count, content, 进入下层嵌套
                        countStack.add(tempCount)
                        contentStack.add(result)
                        // 重置状态
                        tempCount = 0
                        result = StringBuilder()
                    }
                    ']' -> {
                        // 当前嵌套的内容：result，计数：tempCount，生成再拼到上一层的后面
                        val count = countStack.pop().toString().toIntOrNull() ?: 0
                        val appendable = StringBuilder()
                        for (i in 0 until count) {
                            appendable.append(result)
                        }
                        // 与外层嵌套结合 上一层：contentStack.pop()
                        result = contentStack.pop().append(appendable)
                    }
                    in '0'..'9' -> {
                        tempCount = tempCount * 10 + (char - '0')
                    } else -> {
                        result.append(char)
                    }
                }
            }
            return result.toString()
        }
    }
}