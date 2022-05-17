package leetcode

//【二叉树】
class _0297 {

    fun exec(data: String): Int {
        Codec().deserialize2(data)
        return -1
    }

    class Codec() {
        // Encodes a URL to a shortened URL.
        // 1.迭代、栈、bfs
        fun serialize2(root: TreeNode?): String {
            if (root == null) return "[]"
            val result = StringBuilder("[")
            val deque = ArrayDeque<TreeNode>().apply {
                addLast(root)
            }
            // bfs 层序遍历
            while (deque.isNotEmpty()) {
                val node = deque.removeFirst()
                val isNotNull = node.`val` != Int.MIN_VALUE
                result.append(if (isNotNull) node.`val`.toString() else "null").append(',')
                if (isNotNull) {
                    deque.add(node.left ?: TreeNode(Int.MIN_VALUE))
                    deque.add(node.right ?: TreeNode(Int.MIN_VALUE))
                }
            }
            if (result.endsWith(',')) {
                result.deleteCharAt(result.length-1)
            }
            result.append("]")
            return result.toString()
        }

        // Decodes your encoded data to tree.
        fun deserialize2(data: String): TreeNode? {
            val nodes = data.removePrefix("[").removeSuffix("]").split(",")
            if (nodes.isEmpty() || nodes[0].toIntOrNull() == null) {
                return null
            }
            val result = TreeNode(nodes[0].toInt())
            val deque = ArrayDeque<TreeNode>().apply {
                addLast(result)
            }
            var i = 1
            while (deque.isNotEmpty() && i < nodes.size) {
                val node = deque.removeFirst()
                if (node.`val` == Int.MIN_VALUE) continue
                node.left = if (nodes[i].toIntOrNull() == null) null else TreeNode(nodes[i].toInt())
                node.right = if (nodes[i+1].toIntOrNull() == null) null else TreeNode(nodes[i+1].toInt())
                i += 2
                deque.addLast(node.left ?: TreeNode(Int.MIN_VALUE))
                deque.addLast(node.right ?: TreeNode(Int.MIN_VALUE))
            }
            return result
        }

        // todo 题干不限制序列化的遍历顺序，可以用递归+dfs实现先序的排列
    }
}