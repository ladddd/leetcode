package leetcode

class _0450 {
    class Solution {
        // 删除二叉搜索树中的一个节点
        // 目标节点左子树接到右子树最小节点的左侧，再递归
        fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
            if (root == null) {
                return null
            }
            if (root.`val` > key) {
                // 目标节点在左侧，改造它的左子树
                root.left = deleteNode(root.left, key)
                return root
            }
            if (root.`val` < key) {
                root.right = deleteNode(root.right, key)
                return root
            } else {
                if (root.right == null && root.left == null) {
                    // 叶子节点，子树置空即可
                    return null
                }
                // 只有一个子树，返回该子树即可
                if (root.right == null) {
                    return root.left
                }
                if (root.left == null) {
                    return root.right
                }
                // 两颗子树，把*root的左子树*接到*右子树的最小值节点*左侧
                var smallest = root.right!!
                while (smallest.left != null) {
                    smallest = smallest.left!!
                }
                // 递归处理右子树一直到叶子结点
                smallest.right = deleteNode(root.right, smallest.`val`)
                smallest.left = root.left
                return smallest

            }
        }
    }
}