package leetcode

import kotlin.math.abs

class _0110 {
    class Solution {

        // 自下而上
        fun isBalanced(root: TreeNode?): Boolean {
            return height(root) != -1
        }

        // 如果是node为根的树是平衡二叉树，返回树的高度
        // 不是平衡二叉树返回-1
        fun height(node: TreeNode?): Int {
            if (node == null) return 0
            val left = height(node.left)
            if (left == -1) return -1
            val right = height(node.right)
            if (right == -1) return -1
            return if (abs(left - right) <= 1) {
                maxOf(left, right)+1
            } else -1
        }
    }
}