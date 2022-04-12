package leetcode

//【链表】
class _0019 {

    class Solution {

        // 删除链表倒数第n个节点
        // 快慢指针
        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            // 需要有一个dummy头部，因为可能移除的元素是head
            val dummy = ListNode(0).apply {
                this.next = head
            }
            var fast = head
            var slow = dummy
            var count = 0
            while (fast?.next != null) {
                fast = fast.next
                count++
                // 倒数第一个对应 slow == fast
                if (count >= n) {
                    slow = slow.next!!
                }
            }
            // remove slow.next
            val temp = slow.next
            slow.next = slow.next?.next
            temp?.next = null

            return dummy.next
        }
    }
}