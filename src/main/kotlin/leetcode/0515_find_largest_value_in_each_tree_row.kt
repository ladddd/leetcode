package leetcode

//【二叉树】【层序遍历】
class _0515 {
    class Solution {
        fun largestValues(root: TreeNode?): List<Int> {
            val result = arrayListOf<Int>()
            if (root == null) return result
            val list = ArrayDeque<TreeNode>().apply {
                add(root)
            }
            while (list.isNotEmpty()) {
                val levelSize = list.size
                var largest = Int.MIN_VALUE
                for (i in 0 until levelSize) {
                    val node = list.removeFirst()
                    largest = maxOf(largest, node.`val`)
                    node.left?.let { list.addLast(it) }
                    node.right?.let { list.addLast(it) }
                }
                result.add(largest)
            }
            return result
        }
    }
}