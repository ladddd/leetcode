package leetcode

//【链表】【排序】【分治】【归并】
class _0023: ListNodeCase {

    override fun exec(args: Array<ListNode>): Array<ListNode> {
        val result = Solution().mergeKLists(args.copyOf(args.size))
        return if (result == null) emptyArray() else arrayOf(result)
    }

    class Solution {

        // 分治法，以合并两个链表作为原子操作，执行 lists.size / 2 次
        fun mergeKLists(lists: Array<ListNode?>): ListNode? {
            if (lists.isEmpty()) return null
            return mergePart(lists, 0, lists.size - 1)
        }

        fun mergePart(lists: Array<ListNode?>, start: Int, end: Int): ListNode? {
            if (start >= end) return lists[start]
            val mid = (start + end) / 2
            val list1 = mergePart(lists, start, mid)
            val list2 = mergePart(lists, mid+1, end)
            return mergeTwoLists(list1, list2)
        }

        // 0021
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