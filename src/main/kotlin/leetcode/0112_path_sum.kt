package leetcode

//【二叉树】【递归】
class _0112 {
    class Solution {
        fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
            return traversalSearch(root, targetSum)
        }

        fun traversalSearch(node: TreeNode?, targetSum: Int): Boolean {
            // 有孩子必须向下遍历
            if (node?.left != null || node?.right != null) {
                return traversalSearch(node.left, targetSum - node.`val`) ||
                        traversalSearch(node.right, targetSum - node.`val`)
            }
            return node != null && node.`val` == targetSum
        }

        // todo 其他二叉树的遍历方式 dfs bfs
    }
}