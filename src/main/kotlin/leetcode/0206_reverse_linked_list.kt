package leetcode

import java.util.*

//【链表】【迭代】【双指针】【栈】
class _0206: ListNodeCase {

    override fun exec(args: Array<ListNode>): Array<ListNode> {
        val result = Solution().reverseList(args.getOrNull(0))
        return if (result == null) emptyArray() else arrayOf(result)
    }

    class Solution {

        // 双指针
        fun reverseList(head: ListNode?): ListNode? {
            var reversedHead: ListNode? = null
            var current = head
            while (current != null) {
                val temp = reversedHead
                reversedHead = ListNode(current.`val`)
                reversedHead.next = temp
                current = current.next
            }
            return reversedHead
        }

        // 使用栈
        fun reverseList2(head: ListNode?): ListNode? {
            val stack = Stack<Int>()
            var target = head
            while (target != null) {
                stack.push(target.`val`)
                target = target.next
            }
            return if (stack.isEmpty()) {
                null
            } else {
                val reversedHead = ListNode(stack.pop())
                var temp = reversedHead
                while (stack.isNotEmpty()) {
                    temp.next = ListNode(stack.pop())
                    temp = temp.next!!
                }
                reversedHead
            }
        }
    }
}