package leetcode

//【二叉树】【dfs】【bfs】
class _0102 {
    class Solution {
        fun levelOrder(root: TreeNode?): List<List<Int>> {
            if (root == null) return emptyList()
            val result = ArrayList<ArrayList<Int>>()
//            dfs(root, result, 0)
            bfs(root, result)
            return result
        }

        // dfs需要知道插入的节点属于那一层
        fun dfs(root: TreeNode?, result: ArrayList<ArrayList<Int>>, level: Int) {
            if (root == null) {
                return
            }
            if (result.getOrNull(level) == null) {
                result.add(level, ArrayList())
            }
            result[level].add(root.`val`)
            dfs(root.left, result, level+1)
            dfs(root.right, result, level+1)
        }

        fun bfs(root: TreeNode?, result: ArrayList<ArrayList<Int>>) {
            if (root == null) {
                return
            }
            // 用队列实现bfs
            val nodes = ArrayList<TreeNode>()
            nodes.add(root)
            while (nodes.isNotEmpty()) {
                val nums = nodes.size // 该层node数量
                // 该层节点出队
                val level = ArrayList<Int>()
                for (i in 0 until nums) {
                    val node = nodes.removeAt(0)
                    level.add(node.`val`)
                    // 将该节点的孩子插入队列
                    node.left?.let { nodes.add(it) }
                    node.right?.let { nodes.add(it) }
                }
                result.add(level)
            }

        }
    }
}