package leetcode

//【二叉树】
class _0538 {

    // 二叉搜索树转累加树，每个节点的值为大于等于元节点值的所有节点的和：nowValue = preValue + preRightSum
    class Solution {
        var sum = 0
        fun convertBST(root: TreeNode?): TreeNode? {
            if (root == null) return null
            recursion(root)
            return root
        }

        // r2l 中序遍历 递归
        fun recursion(node: TreeNode?) {
            if (node == null) return
            recursion(node.right)
            sum += node.`val`
            node.`val` = sum
            recursion(node.left)
        }
    }
}