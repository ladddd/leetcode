package leetcode

//【栈】【队列】
class _0225 {
    class MyStack() {

        val queue = ArrayDeque<Int>()

        fun push(x: Int) {
            val curSize = queue.size
            queue.add(x)
            // 加入新元素后，旧元素出队再进队
            for (i in 0 until curSize) {
                queue.add(pop())
            }
        }

        fun pop(): Int {
            return queue.removeFirst()
        }

        fun top(): Int {
            return queue.first()
        }

        fun empty(): Boolean {
            return queue.isEmpty()
        }

    }
}