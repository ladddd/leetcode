package leetcode

//【链表】
class _0203 {
    class Solution {
        fun removeElements(head: ListNode?, `val`: Int): ListNode? {
            val result = ListNode(-1)
            result.next = head
            var slow: ListNode? = result
            var fast: ListNode? = slow?.next
            while (fast != null) {
                if (fast.`val` == `val`) {
                    fast = fast.next
                    slow!!.next = fast
                } else {
                    slow = fast
                    fast = fast.next
                }
            }
            return result.next
        }
    }
}