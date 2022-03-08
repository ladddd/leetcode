package leetcode

//【链表】
class _0142: ListNodeCase {

    override fun exec(args: Array<ListNode>): Array<ListNode> {
        val result = Solution().detectCycle(args.getOrNull(0))
        return if (result == null) emptyArray() else arrayOf(result)
    }

    class Solution {

        // 返回入环的节点
        fun detectCycle(head: ListNode?): ListNode? {
            // 使用快慢指针探测
            var slow = head
            var fast = head
            do {
                // 到达链表尾部，表示无环
                if (fast?.next == null) return null
                slow = slow?.next
                fast = fast.next?.next
            } while (slow != fast)
            // 有环
            // 1.slow走了 count 步， fast走了 2*count步：f = 2s
            // 2.两者相遇时fast比slow多走了若干个环的长度：f = s + nb
            // 两者相减计算出 s = nb f = 2nb
            // 此时未知的是head到环入口的位置， slow 此时在nb位置，它距入口的距离和head距入口的位置是相同的
            fast = head
            while (fast != slow) {
                slow = slow?.next
                fast = fast?.next
            }
            return fast
        }
    }
}