package leetcode

//【滑动窗口】【队列】
class _0239: Case {

    override fun exec(args: Array<String>): Array<String> {
        if (args.size < 2) return emptyArray()
        return Solution().maxSlidingWindow(args[0].split(",").map { it.toInt() }.toIntArray(), args[1].toInt()).map { it.toString() }.toTypedArray()
    }

    class Solution {
        fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
            val result = IntArray(nums.size - k + 1) {0}
            val deque = ArrayDeque<Int>(3).apply {

            }
            for (i in nums.indices) {
                // 保证窗口（双向队列）中的大小顺序是从大到小的
                // 注意符号是 <=, 防止队列中加入大量重复的元素
                while (deque.isNotEmpty() && nums[deque.last()] <= nums[i]) {
                    deque.removeLast()
                }
                // 队尾插入新元素，存储的是下标
                deque.addLast(i)
                // 判断队头的元素是否需要出队
                if (deque.first() <= i-k) {
                    deque.removeFirst()
                }
                // 第一个窗口的尾部下标 k-1，deque中第一个是最大的
                if (i+1 >= k) {
                    result[i-k+1] = nums[deque.first()]
                }
            }
            return result
        }
    }
}
