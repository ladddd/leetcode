package leetcode

import java.util.Stack

//【二叉树】
class _0105 {
    class Solution {

        val map = HashMap<Int, Int>()

        // 根据前序遍历和中序遍历构建二叉树
        // 前序遍历[root,[左子树前序遍历],[右子树前序遍历]]
        // 中序遍历[[左子树中序遍历],root,[右子树中序遍历]]
        fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
            // 用一个哈希表来快速定位节点
            for (i in inorder.indices) {
                map[inorder[i]] = i
            }
            return traversalBuild(preorder, inorder, 0, preorder.size-1, 0, inorder.size-1 )
        }

        // 递归
        fun traversalBuild(preorder: IntArray, inorder: IntArray, preStart: Int, preEnd: Int, inStart: Int, inEnd: Int): TreeNode? {
            if (preStart > preEnd) {
                return null
            }
            // 前序遍历的开头是根
            val root = TreeNode(preorder[preStart])
            val inorderIndex = map[root.`val`]!!
            // 获取这个根左子树的大小
            val leftSize = inorderIndex - inStart
            // 递归构造左子树
            root.left = traversalBuild(preorder, inorder, preStart+1, preStart+leftSize, inStart, inorderIndex-1)
            root.right = traversalBuild(preorder, inorder, preStart+leftSize+1, preEnd, inorderIndex+1, inEnd)
            return root
        }

        // 迭代法 *hard*
        fun buildTree2(preorder: IntArray, inorder: IntArray): TreeNode? {
            if (preorder.isEmpty() || inorder.isEmpty()) {
                return null
            }
            val root = TreeNode(preorder[0])
            val stack = Stack<TreeNode>()
            stack.push(root)
            var inorderIndex = 0
            for (i in preorder.indices) {
                val currentRoot = stack.peek()
                if (currentRoot.`val` != inorder[inorderIndex]) {
                    // 在当前跟节点currentRoot的左子树上 拼上左子树
                    currentRoot.left = TreeNode(preorder[i])
                    // 将该节点进栈，之后为其拼上孩子完成子树
                    stack.push(currentRoot.left!!)
                } else {
                    var node: TreeNode? = null
                    while (stack.isNotEmpty() && stack.peek().`val` == inorder[inorderIndex]) {
                        // 从叶子节点开始出栈
                        node = stack.pop()
                        inorderIndex++
                    }
                    node?.right = TreeNode(preorder[i])
                    node?.right?.let { stack.push(it) }
                }
            }
            return root
        }
    }
}