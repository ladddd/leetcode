package leetcode

class _0160: ListNodeCase {

    override fun exec(args: Array<ListNode>): Array<ListNode> {
        if (args.size < 2) return emptyArray()
        val result = Solution().getIntersectionNode(args[0], args[1])
        return if (result == null) emptyArray() else arrayOf(result)
    }

    class Solution {
        fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
            if (headA == null || headB == null) return null
            var tempA = headA
            var tempB = headB

            // 让tempA和tempB 遍历一遍a和b
            // 这里比较的是对象是否是同一个，不是被覆盖的比较toString()
            while (tempA != tempB) {
                tempA = if (tempA == null) headB else tempA.next
                tempB = if (tempB == null) headA else tempB.next
            }
            return tempA
        }
    }
}