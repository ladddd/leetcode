package leetcode

//【二叉树】【遍历】【dfs】【迭代】
class _0094 {

    class Solution {

        // 中序遍历 left - root - right
        fun inorderTraversal(root: TreeNode?): List<Int> {
            val result = arrayListOf<Int>()
            dfs(root, result)
            return result
        }

        fun dfs(node: TreeNode?, list: ArrayList<Int>) {
            if (node == null) return
            dfs(node.left, list)
            list.add(node.`val`)
            dfs(node.right, list)
        }
    }

}