package leetcode

class _0145 {
    class Solution {
        fun postorderTraversal(root: TreeNode?): List<Int> {
            val result = ArrayList<Int>()
            var temp = root
            traversal(temp, result)
            return result
        }

        fun traversal(node: TreeNode?, nodeList: ArrayList<Int>) {
            if (node == null) return
            traversal(node.left, nodeList)
            traversal(node.right, nodeList)
            nodeList.add(node.`val`)
        }
    }
}