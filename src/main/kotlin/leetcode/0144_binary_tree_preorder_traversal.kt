package leetcode

class _0144 {
    class Solution {
        fun preorderTraversal(root: TreeNode?): List<Int> {
            val result = ArrayList<Int>()
            var temp = root
            traversal(temp, result)
            return result
        }

        fun traversal(node: TreeNode?, nodeList: ArrayList<Int>) {
            if (node == null) return
            nodeList.add(node.`val`)
            traversal(node.left, nodeList)
            traversal(node.right, nodeList)
        }
    }
}