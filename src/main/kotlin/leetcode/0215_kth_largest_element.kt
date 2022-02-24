package leetcode

//【数组】【快速排序】【堆排序】
class _0215 {

    fun exec(nums: IntArray, k: Int): Int {
        return Solution().findKthLargest3(nums, k)
    }

    class Solution {

        // api
        fun findKthLargest(nums: IntArray, k: Int): Int {
            return nums.sortedDescending()[k-1]
        }

//        // 快速选择 O(n) = n，在指定区间内选择一个值作为轴，遍历区间，移动该轴到某个位置，使*轴左边的都比轴小，轴右边的逗比轴大*
//        fun findKthLargest2(nums: IntArray, k: Int): Int {
//            return quickSelect(nums, 0, nums.size - 1, nums.size - k)
//        }
//
//        fun quickSelect(nums: IntArray, left: Int, right: Int, target: Int): Int {
//            val pivot = findPivotInPartition(nums, left, right)
//            // 根据轴相距目标的位置，每次仅递归一个区间，保证轴左边都比轴小，右边都比轴大
//            return when {
//                pivot == target -> {
//                    nums[pivot]
//                }
//                pivot < target -> {
//                    quickSelect(nums, pivot + 1, right, target)
//                }
//                pivot > target -> {
//                    quickSelect(nums, left, pivot - 1, target)
//                }
//                else -> -1
//            }
//        }
//
//        // 在该区间内做快排
//        fun findPivotInPartition(nums: IntArray, left: Int, right: Int): Int {
//            val pivot = nums[left] // 取第一位的值作为轴，输出排序后轴值的位置 j
//            var j = left
//            // 遍历该区间
//            for (i in left+1..right) {
//                if (nums[i] < pivot) {
//                    // 将小于轴的值插到轴的前面
//                    j++
//                    swap(nums, i, j)
//                }
//            }
//            swap(nums, j, left) // 交换轴值
//            return j
//        }
//
        fun swap(nums: IntArray, i: Int, j: Int) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        }

        // 手写堆排: 大根堆
        fun findKthLargest3(nums: IntArray, k: Int): Int {
            // 建堆
            buildMaxHeap(nums, nums.size)
            // 删除k-1次堆顶元素，最后第一个就是第k元素
            // 删除就是将nums[0]移动到最后一位，再将堆大小缩小
            for (i in nums.size - 1 downTo nums.size - k + 1) {
                swap(nums, 0, i)
                maxHeapify(nums, 0, i)
            }
            return nums[0]
        }

        // 调整数组内元素的顺序， 使其成为一个大根堆
        fun buildMaxHeap(nums: IntArray, size: Int) {
            // size / 2，根节点的位置不超过size/2，size/2之后的都是子节点
            for (i in size/2 downTo 0) {
                maxHeapify(nums, i, size)
            }
        }

        fun maxHeapify(nums: IntArray, index: Int, size: Int) {
            // 用数组模拟二叉树，左节点的位置
            val leftChildIndex = index * 2 + 1
            val rightChildIndex = index * 2 + 2
            var largestIndex = index
            // 比较左右节点和index位置的值，将较大的替换到index
            if (leftChildIndex < size && nums[leftChildIndex] > nums[largestIndex]) {
                largestIndex = leftChildIndex
            }
            if (rightChildIndex < size && nums[rightChildIndex] > nums[largestIndex]) {
                largestIndex = rightChildIndex
            }
            if (largestIndex != index) {
                swap(nums, largestIndex, index)
                // 递归调整交换下来的节点
                maxHeapify(nums, largestIndex, size)
            }
        }
    }
}