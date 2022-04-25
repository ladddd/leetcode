package leetcode

import java.util.Stack

//【二叉树】【递归】
class _0098 {

    class Solution {

        // 二叉搜索树的特性是：对于树中每个节点，它的左子树都比它小
        // 右子树都比它大
        // * 对二叉搜索树中序遍历得到的是一个递增的序列，可以用栈来实现
        // 或者递归函数，空间复杂度都是O(n)
        fun isValidBST(root: TreeNode?): Boolean {
            return recursion(root,Long.MIN_VALUE, Long.MAX_VALUE )
        }

        // 递归
        fun recursion(node: TreeNode?, lower: Long, upper: Long) :Boolean {
            if (node == null) {
                return true
            }
            if (node.`val` <= lower|| node.`val` >= upper) {
                return false
            }
            return recursion(node.left, lower, node.`val`.toLong()) && recursion(node.right, node.`val`.toLong(), upper)
        }

        fun isValidBST2(root: TreeNode?): Boolean {
            val stack = Stack<TreeNode>()
            var temp = root
            var min = Long.MIN_VALUE
            while (stack.isNotEmpty() || temp != null) {
                // 先判断左子树，将所有左孩子压入栈中
                while (temp != null) {
                    stack.push(temp)
                    temp = temp.left
                }
                // root
                temp = stack.pop()
                if (temp.`val` <= min) {
                    return false
                }
                min = temp.`val`.toLong()
                // right
                temp = temp.right
            }
            return true
        }
    }
}