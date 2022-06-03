package leetcode

//【二叉树】【递归】
class _0108 {

    fun exec(nums: IntArray) {
        val tree = Solution().sortedArrayToBST(nums)
    }

    class Solution {
        // 升序数组转二叉搜索树（左子树都比根小，右子树都比根大）
        fun sortedArrayToBST(nums: IntArray): TreeNode? {
            return traversalBuild(nums, 0, nums.size-1)
        }

        fun traversalBuild(nums: IntArray, low: Int, high: Int): TreeNode? {
            if (nums.isEmpty() || low > high) {
                return null
            }
            // 如果区间里只有两个元素，那么选取大的做根，就是根+左子树，选取小的做根，就是根+右子树
//            val mid = low + (high-low)/2 // 整数除法向下取整，是根+右子树
            val mid = low + (high-low+1)/2 // 向上取整，根+左子树
            val node = TreeNode(nums[mid])
            node.left = traversalBuild(nums, low, mid-1)
            node.right = traversalBuild(nums, mid+1, high)
            return node
        }
    }
}