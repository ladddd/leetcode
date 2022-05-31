package leetcode

//【链表】
class _0083 {
    class Solution {
        fun deleteDuplicates(head: ListNode?): ListNode? {
            var slow = head
            var fast = slow?.next
            while (fast != null) {
                if (slow!!.`val` == fast.`val`) {
                    slow.next = fast.next
                    fast = slow.next
                } else {
                    val temp = fast
                    fast = fast.next
                    slow = temp
                }
            }
            return head
        }
    }
}