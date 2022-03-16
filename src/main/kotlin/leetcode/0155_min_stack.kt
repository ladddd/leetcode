package leetcode

import java.util.*

//【栈】【数据结构】
class _0155 {

    // 设计一个栈，要求尽可能快速的找到栈中的最小值
    class MinStack() {

        // 只用一个栈的方式，是同时保存当前值和最小值
        val stack = Stack<Pair<Int, Int>>()

        fun push(`val`: Int) {
            val min = if (stack.isEmpty()) `val` else minOf(stack.peek().second, `val`)
            stack.push(Pair(`val`, minOf(min, `val`)))
        }

        fun pop() {
            stack.pop()
        }

        fun top(): Int {
            return if (stack.isEmpty()) 0 else stack.peek().first
        }

        fun getMin(): Int {
            return if (stack.isEmpty()) 0 else stack.peek().second
        }

    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * var obj = MinStack()
     * obj.push(`val`)
     * obj.pop()
     * var param_3 = obj.top()
     * var param_4 = obj.getMin()
     */
}