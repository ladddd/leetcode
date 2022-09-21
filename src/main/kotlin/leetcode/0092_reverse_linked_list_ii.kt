package leetcode

//【链表】
class _0092 {
    class Solution {
        fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
            val dummy = ListNode(-1).apply {
                next = head
            }

            var tempPre = dummy
            var tempCur: ListNode? = tempPre.next
            var count = 1
            var leftPreNode: ListNode? = null
            var rightNode: ListNode? = null

            while (tempCur != null) {
                if (count == left) {
                    leftPreNode = tempPre
                }
                // left 可能和 right 相同
                if (count == right) {
                    rightNode = tempCur
                }
                tempPre = tempPre.next!!
                tempCur = tempCur.next
                count++
            }


            // 逆转链
            val nodeOfLeft = leftPreNode?.next
            val nodeOfRightNext = rightNode?.next
            leftPreNode?.next = null
            rightNode?.next = null

            println("${leftPreNode?.`val` ?: -1}")
            println("${rightNode?.`val` ?: -1}")
            println("${nodeOfLeft?.`val` ?: -1}")
            println("${nodeOfRightNext?.`val` ?: -1}")

            reverseList(nodeOfLeft)

            leftPreNode?.next = rightNode
            nodeOfLeft?.next = nodeOfRightNext
            return dummy.next
        }

        fun reverseList(head: ListNode?) {
            var pre: ListNode? = null
            var cur = head

            while (cur != null) {
                val next = cur.next
                cur.next = pre
                pre = cur
                cur = next
            }
        }
    }
}