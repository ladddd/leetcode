package leetcode

class _0621 {

    class Solution {

        // 每种任务耗时1，再次执行有冷却时间n，求所有任务最快执行完成时间
        fun leastInterval(tasks: CharArray, n: Int): Int {
            val sorted = tasks.sortedBy { char -> char-'a' }
            return 0
        }
    }
}