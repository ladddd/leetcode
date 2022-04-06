package leetcode

//【二叉树】
class _0543 {

    // 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点
    class Solution {

        // 每个节点的直径：最长左子树路径 + 最长右子树路径 + 1
        fun diameterOfBinaryTree(root: TreeNode?): Int {
            depth(root)
            return result
        }

        var result = 0
        fun depth(root: TreeNode?): Int {
            if (root == null) {
                return 0
            }
            val left = depth(root.left) // 左子树最大深度
            val right = depth(root.right) // 右子树最大深度
            // 直径 = left + right
            result = maxOf(left + right, result)
            return maxOf(left, right) + 1
        }
    }
}