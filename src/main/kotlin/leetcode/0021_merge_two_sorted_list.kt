package leetcode

//【链表】【递归】【迭代】
class _0021: ListNodeCase {

    override fun exec(args: Array<ListNode>): Array<ListNode> {
        if (args.size < 2) return emptyArray()
        val result = Solution().mergeTwoLists(args[0], args[1])
        return if (result == null) emptyArray() else arrayOf(result)
    }

    class Solution {

        // 递归 *迭代自身的写法更加简洁，但因为要将上下文存入程序栈中，内存开销大*
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

        // 迭代
        fun mergeTwoLists2(list1: ListNode?, list2: ListNode?): ListNode? {
            var temp1 = list1
            var temp2 = list2
            var head: ListNode? = null
            var temp: ListNode? = head
            while (temp1 != null || temp2 != null) {
                val v1 = temp1?.`val` ?: Int.MAX_VALUE
                val v2 = temp2?.`val` ?: Int.MAX_VALUE
                val target = if (v1 < v2) {
                    temp1 = temp1?.next
                    v1
                } else {
                    temp2 = temp2?.next
                    v2
                }
                if (head == null) {
                    head = ListNode(target)
                    temp = head
                } else {
                    temp?.next = ListNode(target)
                    temp = temp?.next
                }
            }
            return head
        }
    }
}