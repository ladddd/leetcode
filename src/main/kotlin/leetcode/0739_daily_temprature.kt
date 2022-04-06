package leetcode

import java.util.Stack

//【栈】
class _0739 {

    class Solution {
        fun dailyTemperatures(temperatures: IntArray): IntArray {
            val stack = Stack<Int>()
            val result = IntArray(temperatures.size)
            for (i in temperatures.indices) {
                if (stack.isNotEmpty()) {
                    while (stack.isNotEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                        val index = stack.pop()
                        result[index] = i - index
                    }
                }
                stack.push(i)
            }
            return result
        }
    }
}