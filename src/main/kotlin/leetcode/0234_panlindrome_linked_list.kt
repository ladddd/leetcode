package leetcode

//【链表】【递归】
class _0234 {

    fun exec(head: ListNode?): Boolean {
        return Solution().isPalindrome2(head)
    }

    class Solution {

        // 用数组
        fun isPalindrome(head: ListNode?): Boolean {
            val list = ArrayList<Int>()
            var temp = head
            // 这里没有判断是否有环，会死循环
            while (temp != null) {
                list.add(temp.`val`)
                temp = temp.next
            }
            if (list.isEmpty()) {
                return false
            }
            var h = 0
            var t = list.size-1
            while (h < t) {
                if (list[h] != list[t]) {
                    return false
                }
                h++
                t--
            }
            return true
        }

        fun reverseList(head: ListNode?): ListNode? {
            var reversedHead: ListNode? = null
            var current = head
            while (current != null) {
                val temp = reversedHead
                reversedHead = ListNode(current.`val`)
                reversedHead.next = temp
                current = current.next
            }
            return reversedHead
        }

        // 空间复杂度O(1)
        // 快慢指针找到中间的节点
        fun isPalindrome2(head: ListNode?): Boolean {
            var slow = head
            var fast = head
            do {
                if (fast == null) break
                slow = slow?.next
                fast = fast.next?.next
            } while (slow != fast)
            // loop出来slow正停留后半部分的起点
            // 构建后半部分的翻转链表 206
            val secondHalf = reverseList(slow)
            // 比较前半部分链表和后半部分的反转链表
            var temp1 = head
            var temp2 = secondHalf
            while (temp2 != null) {
                if (temp1?.`val` != temp2.`val`) {
                    return false
                }
                temp1 = temp1.next
                temp2 = temp2.next
            }
            return true
        }
    }
}