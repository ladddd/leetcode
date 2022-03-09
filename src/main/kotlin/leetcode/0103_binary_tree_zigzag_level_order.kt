package leetcode

//【二叉树】【bfs】【dfs】
class _0103 {

    class Solution {

        // 返回二叉数的层级列表（从根节点开始）
        fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
            if (root == null) return emptyList()
            val result = ArrayList<ArrayList<Int>>()
//            dfs(root, result, 0)
            bfs(root, result)
            return result
        }

        // 递归
        // 深度遍历，根据层数拼在列表的头部或尾部
        fun dfs(root: TreeNode?, levels: ArrayList<ArrayList<Int>>, level: Int) {
            if (root == null) return
            if (levels.getOrNull(level) == null) {
                levels.add(level, arrayListOf())
            }
            // 根据level的奇偶来判断往队列的头部或者尾部插入
            if (level % 2 == 0) {
                levels[level].add(root.`val`)
            } else {
                levels[level].add(0, root.`val`)
            }
            dfs(root.left, levels, level+1)
            dfs(root.right, levels, level+1)
        }

        // 使用双向队列迭代获取一整层的排列，根据不同层数选择出队方式（头部，尾部）
        fun bfs(root: TreeNode?, levels: ArrayList<ArrayList<Int>>) {
            if (root == null) return
            val nodes = ArrayDeque<TreeNode>()
            nodes.add(root)
            var l2r = true
            while (nodes.isNotEmpty()) {
                val values = ArrayDeque<Int>()
                val num = nodes.size // 当前层的node个数
                for (i in 0 until num) {
                    // nodes 从对头出队，从队尾插入
                    val node = nodes.removeFirst()
                    if (l2r) {
                        values.add(node.`val`)
                    } else {
                        values.addFirst(node.`val`)
                    }

                    // nodes 队尾插入下一层的node
                    node.left?.let { nodes.add(it) }
                    node.right?.let { nodes.add(it) }
                }
                levels.add(arrayListOf(*values.toTypedArray()))
                l2r = !l2r
            }
        }
    }
}