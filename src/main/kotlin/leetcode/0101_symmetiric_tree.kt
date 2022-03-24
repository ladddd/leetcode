package leetcode

//【二叉树】【层序遍历】【递归】
class _0101 {

    class Solution {

        // 判断二叉树是否轴对称
        fun isSymmetric(root: TreeNode?): Boolean {
            // 同时逐层遍历左右子树
            // 从根节点开始，
            return checkPair(root, root)
        }

        fun checkPair(left: TreeNode?, right: TreeNode?): Boolean {
            return if (left == null && right == null) true
            else if (left == null || right == null) false
            else {
                // 都不为空，递归判断下一层
                // 轴对称，所以比较left.left/right.right left.right/right.left
                left.`val` == right.`val` && checkPair(left.left, right.right) && checkPair(left.right, right.left)
            }
        }
    }
}