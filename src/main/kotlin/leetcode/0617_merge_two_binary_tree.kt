package leetcode

//【二叉树】【dfs】【bfs】【递归】
class _0617 {

    class Solution {

        fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
            if (root1 == null) return root2
            if (root2 == null) return root1
            val merged = TreeNode(root1.`val` + root2.`val`)
            merged.left = mergeTrees(root1.left, root2.left)
            merged.right = mergeTrees(root1.right, root2.right)
            return merged
        }

        // 利用队列实现bfs
    }
}