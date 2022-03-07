package leetcode

//【链表】【迭代】【递归】
class _0002: ListNodeCase {

    override fun exec(args: Array<ListNode>): Array<ListNode> {
        val result = Solution().addTwoNumbers(args.getOrNull(0), args.getOrNull(1))
        return if (result == null) emptyArray() else arrayOf(result)
    }

    class Solution {
        fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
            var head: ListNode? = null
            var temp = head
            var temp1 = l1
            var temp2 = l2
            var carrier = 0
            while (temp1 != null || temp2 != null || carrier != 0) {
                val num1 = temp1?.`val` ?: 0
                val num2 = temp2?.`val` ?: 0
                val sum = num1 + num2 + carrier
                carrier = sum / 10
                val newNode = ListNode(sum % 10)
                if (temp == null) {
                    head = newNode
                    temp = head
                } else {
                    temp.next = newNode
                    temp = newNode
                }
                temp1 = temp1?.next
                temp2 = temp2?.next
            }
            return head
        }
    }
}