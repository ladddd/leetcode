package leetcode

import java.util.PriorityQueue

//【优先级队列】
class _0347: Case {

    override fun exec(args: Array<String>): Array<String> {
        return Solution().topKFrequent(args[0].split(",").map { it.toInt() }.toIntArray(), args[1].toInt()).map { it.toString() }.toTypedArray()
    }

    class Solution {
        val counter = HashMap<Int, Int>()

        fun topKFrequent(nums: IntArray, k: Int): IntArray {
            val pq = PriorityQueue<Int> { o1, o2 ->
                // 需要出现次数多的在队头
                -((counter[o1] ?: 0) - (counter[o2] ?: 0))
            }
            // 统计各个数字出现的个数
            for (num in nums) {
                counter[num] = (counter[num] ?: 0) + 1
            }
            for (key in counter.keys) {
                pq.add(key)
            }
            val result = IntArray(k)
            for (i in 0 until k) {
                result[i] = pq.poll()
            }
            return result
        }
    }
}