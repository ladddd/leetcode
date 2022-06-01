package leetcode

//【二叉树】【dfs】
class _0100 {
    class Solution {
        fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
            return if (p == null && q == null) {
                true
            } else if (p == null || q == null) {
                false
            } else if (p.`val` != q.`val`) {
                false
            } else {
                isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
            }
        }
    }
}