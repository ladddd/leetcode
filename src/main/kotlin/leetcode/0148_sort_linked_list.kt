package leetcode

//【链表】【排序】【分治】【归并】
class _0148: ListNodeCase {

    override fun exec(args: Array<ListNode>): Array<ListNode> {
        val result = Solution().sortList(args.getOrNull(0))
        return if (result == null) emptyArray() else arrayOf(result)
    }

    class Solution {

        fun sortList(head: ListNode?): ListNode? {
            return sortList(head, null) // tail=null表示
        }

        // 分治
        fun sortList(head: ListNode?, tail: ListNode?): ListNode? {
            if (head == null) {
                return head
            }
            if (head.next == tail) {
                head.next = null
                return head
            }

            // 链表使用快慢两个指针二分链表，两部分分别排序
            var fast = head
            var slow = head
            while (fast != null && slow != null && fast != tail) {
                slow = slow.next
                fast = fast.next
                if (fast != tail) {
                    fast = fast?.next
                }
            }
            // head - slow - tail
            // 排序两个子列表
            val subList1 = sortList(head, slow)
            val subList2 = sortList(slow, tail)
            // 排序完，归并
            return mergeTwoLists(subList1, subList2)
        }

        // 0021 merge two sorted list
        fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
            if (list1 == null) {
                return list2
            }
            if (list2 == null) {
                return list1
            }
            return if (list1.`val` < list2.`val`) {
                list1.next = mergeTwoLists(list1.next, list2)
                list1
            } else {
                list2.next = mergeTwoLists(list1, list2.next)
                list2
            }
        }
    }
}