package leetcode

//【数组】【分治】【递归】
class _0169: Case {

    override fun exec(args: Array<String>): Array<String> {
        return arrayOf(Solution().majorityElement(args.map { it.toInt() }.toIntArray()).toString())
    }

    // 找出超出占数组容量一半以上的元素
    class Solution {

        // hashmap
        fun majorityElement(nums: IntArray): Int {
            val map = HashMap<Int, Int>()
            // count
            for (i in nums) {
                map[i] = map.getOrDefault(i, 0) + 1
            }
            for (key in map.keys) {
                if ((map[key] ?: 0) > nums.size / 2) {
                    return key
                }
            }
            return 0
        }

        // 排序后取 nums.size/2 位置的元素
        fun majorityElement2(nums: IntArray): Int {
            return nums.sorted()[nums.size/2]
        }

        // 分治
        fun majorityElement3(nums: IntArray): Int {
            return majorityElementOfPart(nums, 0, nums.size - 1)
        }

        fun majorityElementOfPart(nums: IntArray, start: Int, end: Int): Int {
            if (start >= end) { // 递归结束条件
                return nums[start]
            }

            val mid = (start + end)/2
            val left = majorityElementOfPart(nums, start, mid)
            val right = majorityElementOfPart(nums, mid+1, end)

            // 两侧数量最多的元素是同一个
            if (left == right) {
                return left
            }
            // 比较left和right在各自区间的数量
            val leftCount = numberCount(nums, left, start, mid)
            val rightCount = numberCount(nums, right, mid+1, end)

            return if (leftCount > rightCount) left else right
        }

        fun numberCount(nums: IntArray, num: Int, start: Int, end: Int): Int {
            var count = 0
            for (i in start..end) {
                count += if (nums[i] == num) 1 else 0
            }
            return count
        }
    }
}