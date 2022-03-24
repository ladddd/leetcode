package leetcode

//【二叉树】【dfs】【bfs】
class _0104 {

    class Solution {

        fun maxDepth(root: TreeNode?): Int {
            return dfs(root, 0)
        }

        // 可以剪枝？
        fun dfs(node: TreeNode?, level: Int): Int {
            if (node == null) {
                return level
            } else {
                return maxOf(dfs(node.left, level+1), dfs(node.right, level+1))
            }
        }

        // 使用队列实现bfs
        fun maxDepth2(node: TreeNode?): Int {
            if (node == null) return 0
            val queue = ArrayDeque<TreeNode>()
            queue.addLast(node)
            var count = 0
            while (queue.isNotEmpty()) {
                val levelSize = queue.size
                count++
                for (i in 0 until levelSize) {
                    val n = queue.removeFirst()
                    n.left?.let { queue.addLast(it) }
                    n.right?.let { queue.addLast(it) }
                }
            }
            return count
        }
    }
}