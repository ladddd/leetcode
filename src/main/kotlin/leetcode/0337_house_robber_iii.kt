package leetcode

//【dp】【dfs】
class _0337 {

    // 二叉树版本198 打家劫舍
    class Solution {

        fun rob(root: TreeNode?): Int {
            // 动态规划的记录空间变为Map
            val chosen = HashMap<TreeNode, Int>() // 记录某个节点作为根且被选中，最大收益
            val unChosen = HashMap<TreeNode, Int>() // 作为根未被选中时的最大收益
            dfs(root, chosen, unChosen)
            return maxOf(chosen[root] ?: 0, unChosen[root] ?: 0)
        }

        fun dfs(node: TreeNode?, chosen: HashMap<TreeNode, Int>, unChosen: HashMap<TreeNode, Int>) {
            if (node == null) {
                return
            }
            // dfs到叶子节点，逐级向上
            dfs(node.left, chosen, unChosen)
            dfs(node.right, chosen, unChosen)
            chosen[node] = (unChosen[node.left] ?: 0) + (unChosen[node.right] ?: 0) + node.`val`
            // 未选中，两个孩子最优方案*相加* left：max(chosen[left], unChosen[left]); right：max(chosen[right], unChosen[right])
            unChosen[node] = maxOf(chosen[node.left] ?: 0, unChosen[node.left] ?: 0) +  maxOf(unChosen[node.right] ?: 0, chosen[node.right] ?: 0)
        }

        // 用返回一个数组省去hash表开销
        fun dfs(node: TreeNode?): Array<Int> {
            val result = Array(2) {0}
            if (node == null) {
                return result
            }
            val left = dfs(node.left)
            val right = dfs(node.right)
            // 0选中，1未选中
            result[0] = left[1] + right[1] + node.`val`
            result[1] = maxOf(left[0], left[1]) + maxOf(right[0], right[1])
            return result
        }
    }
}