package leetcode

//【二叉树】
class _0513 {
    class Solution {
        // 找最底部最左侧的值，考虑用层序遍历
        fun findBottomLeftValue(root: TreeNode?): Int {
            if (root == null) return 0
            var result = root.`val`
            val deque = ArrayDeque<TreeNode>().apply {
                addLast(root)
            }
            while (deque.isNotEmpty()) {
                val levelSize = deque.size
                for (i in 0 until levelSize) {
                    val node = deque.removeFirst()
                    if (i == 0) {
                        result = node.`val`
                    }
                    node.left?.let { deque.addLast(it) }
                    node.right?.let { deque.addLast(it) }
                }
            }
            return result
        }
    }
}