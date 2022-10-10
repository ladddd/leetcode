package leetcode

import java.util.*

//【栈】
class _0856 {

    class Solution {
        fun scoreOfParentheses(s: String): Int {
            if (s.isEmpty()) return 0
            val stack = Stack<Int>().apply {
                push(0)
            }
            for (char in s) {
                if (char == '(') {
                    stack.push(0)
                } else {
                    // )
                    // 弹出该区块的累计分值
                    val block = stack.pop()
                    // maxOf(2 * score, 1) 右括号包了一组 2*score，只和左括号配对 1
                    // stack.pop() 第二次弹出的是同一层的分
                    stack.push(stack.pop() + maxOf(2 * block, 1))
                }
            }
            return stack.peek()
        }

        // todo 分治
    }
}