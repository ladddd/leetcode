package leetcode

//【二叉树】【dfs】
class _0104 {

    class Solution {

        //
        fun maxDepth(root: TreeNode?): Int {
            return dfs(root, 0)
        }

        fun dfs(node: TreeNode?, level: Int): Int {
            if (node == null) {
                return level
            } else {
                return maxOf(dfs(node.left, level+1), dfs(node.right, level+1))
            }
        }
    }
}