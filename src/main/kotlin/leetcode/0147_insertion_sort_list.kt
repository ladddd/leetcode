package leetcode

//【链表】【排序】
class _0147 {

    // 要求使用插入排序
    class Solution {
        fun insertionSortList(head: ListNode?): ListNode? {
            val dummy = ListNode(Int.MIN_VALUE)
            var current = head
            while (current != null) {
                var compareNode: ListNode? = dummy
                while (compareNode != null) {
                    // 不存在插dummy左侧的情况
                    if ((compareNode.next?.`val` ?: Int.MAX_VALUE) > current.`val`) {
                        // 插右侧
                        val elderNext = compareNode.next
                        val newNext = ListNode(current.`val`)
                        compareNode.next = newNext
                        newNext.next = elderNext
                        break
                    }
                    compareNode = compareNode.next
                }
                current = current.next
            }
            return dummy.next
        }
    }
}