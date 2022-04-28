package leetcode

//【二叉树】【递归】
class _0114 {

    class Solution {

        // 递归解法
        fun flatten(root: TreeNode?): Unit {
            if (root == null) {
                return
            }
            // 递归处理左子树
            flatten(root.left)
            // 将处理完的左子树接到右边（先序）
            val oriRight = root.right
            var tempRoot = root
            root.right = root.left
            root.left = null
            // 再将元右子树接到最右
            while (tempRoot?.right != null) {
                tempRoot = tempRoot.right
            }
            // 处理元右子树
            flatten(oriRight)
            tempRoot?.right = oriRight
        }

        fun flatten2(root: TreeNode?): Unit {
            var temp = root
            while (temp != null) {
                if (temp.left == null) {
                    temp = temp.right
                    continue
                }
                // 如果有左子树的话
                // 1.找到左子树最右边的孩子，将右子树接到该元素的右边
                var rightLeaf = temp.left
                while (rightLeaf?.right != null) {
                    rightLeaf = rightLeaf.right
                }
                rightLeaf?.right = temp.right
                // 2.将左子树接到右边
                temp.right = temp.left
                temp.left = null
                temp = temp.right
            }
        }
    }
}