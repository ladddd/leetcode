package leetcode

//【二叉树】【bfs】
class _0111 {
    class Solution {
        fun minDepth(root: TreeNode?): Int {
            var result = 0
            val deque = ArrayDeque<TreeNode>()
            if (root != null) {
                deque.addLast(root)
                var levelNodesNum = deque.size
                while (deque.isNotEmpty()) {
                    if (--levelNodesNum == 0) {
                        result++
                        levelNodesNum = deque.size
                    }
                    val node = deque.removeFirst()
                    if (node.left == null && node.right == null) {
                        break
                    } else {
                        node.left?.let { deque.addLast(it) }
                        node.right?.let { deque.addLast(it) }
                    }
                }
            }
            return result
        }
    }
}