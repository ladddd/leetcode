package leetcode

//【链表】
class _0237 {
    class Solution {
        fun deleteNode(node: ListNode?) {
            // 给定节点删除，将下一个节点复制给当前节点
            node?.`val` = node?.next?.`val` ?: 0
            node?.next = node?.next?.next
        }
    }
}