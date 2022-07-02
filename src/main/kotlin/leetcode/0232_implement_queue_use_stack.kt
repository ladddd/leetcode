package leetcode

import java.util.Stack

class _0232 {
    class MyQueue() {
        val stack = Stack<Int>()

        fun push(x: Int) {
            stack.push(x)
        }

        fun pop(): Int {
            val temp = Stack<Int>()
            while (stack.isNotEmpty()) {
                temp.push(stack.pop())
            }
            val result = temp.pop()
            while (temp.isNotEmpty()) {
                stack.push(temp.pop())
            }
            return result
        }

        fun peek(): Int {
            val temp = Stack<Int>()
            while (stack.isNotEmpty()) {
                temp.push(stack.pop())
            }
            val result = temp.peek()
            while (temp.isNotEmpty()) {
                stack.push(temp.pop())
            }
            return result
        }

        fun empty(): Boolean {
            return stack.isEmpty()
        }

    }
}