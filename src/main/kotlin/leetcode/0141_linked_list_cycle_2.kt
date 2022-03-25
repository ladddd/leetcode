package leetcode

//【链表】
class _0141 {

    class Solution {

        // 使用hashmap
        fun hasCycle(head: ListNode?): Boolean {
            val set = HashSet<ListNode>()
            var temp = head
            while (temp != null) {
                if (set.contains(temp)) {
                    return true
                } else {
                    set.add(temp)
                    temp = temp.next
                }
            }
            return false
        }

        // 快慢指针，两者相遇说明有环
        fun hasCycle2(head: ListNode?): Boolean {
            var slow = head
            var fast = head
            do {
                // 到达链表尾部，表示无环
                if (fast?.next == null) return false
                slow = slow?.next
                fast = fast.next?.next
            } while (slow != fast)
            return false
        }
    }
}