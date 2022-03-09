package leetcode

//【二叉树】【DFS】【递归】
class _0236 {

    class Solution {
        // 1.寻找是p和q祖先的节点
        fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
            // 如果p、q是根节点，表示p或q是两者的共同祖先，不需要递归查询
            if (root == null || p == root || q == root) return root
            val left = lowestCommonAncestor(root.left, p, q) // 查找左子树pq的共同祖先
            val right = lowestCommonAncestor(root.right, p, q) // 右子树
            // 左子树没有共同祖先，p、q都在右子树上
            if (left == null) return right
            // 右子树没有共同祖先，p、q都在左子树上
            if (right == null) return left
            // p、q在root的两侧，root即是共同祖先
            return root
        }
    }
}