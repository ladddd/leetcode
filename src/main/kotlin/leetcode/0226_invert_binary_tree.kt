package leetcode

//【二叉树】【递归】
class _0226 {

    class Solution {

        fun invertTree(root: TreeNode?): TreeNode? {
            return invertNode(root)
        }

        fun invertNode(node: TreeNode?): TreeNode? {
            if (node == null) return null
            val newRight = invertNode(node.left)
            val newLeft = invertNode(node.right)
            node.right = newRight
            node.left = newLeft
            return node
        }
    }
}