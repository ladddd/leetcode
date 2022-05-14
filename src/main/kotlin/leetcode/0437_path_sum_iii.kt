package leetcode

//【二叉树】【前缀和】【dfs】【回溯】
class _0437 {

    // 求所有路径和为targetSum的路径，路径可以不由root开始
    class Solution {
        fun pathSum(root: TreeNode?, targetSum: Int): Int {
            // <路径和, 该路径和的路径数>
            // map中保存的都是从跟节点开始的路径和, root-n1, root-n2, 两条路径和的差值即是路径 n1-n2
            val prefixSums = HashMap<Long, Int>().apply {
                this[0] = 1 // sum=0的路径
            }
            return dfs(root, prefixSums, 0L, targetSum)
        }

        fun dfs(node: TreeNode?, prefixSums: HashMap<Long, Int>, prefixSum: Long, targetSum: Int): Int {
            if (node == null) {
                return 0
            }
            val currentPrefixSum = prefixSum + node.`val`
            var result = prefixSums.getOrDefault( currentPrefixSum - targetSum, 0)
            // 记录当前节点到前缀和map，进行下一步遍历左右孩子
            prefixSums[currentPrefixSum] = prefixSums.getOrDefault(currentPrefixSum, 0) + 1
            result += dfs(node.left, prefixSums, currentPrefixSum, targetSum)
            result += dfs(node.right, prefixSums, currentPrefixSum, targetSum)
            // 回溯：深度优先遍历完成某条路径后，需要清除该路径上的前缀和，避免影响其他不相连的路径
            prefixSums[currentPrefixSum] = prefixSums.getOrDefault(currentPrefixSum, 0) -1
            return result
        }
    }
}