package leetcode

//【桶】
class _0621 {

    /**
     * -A-｜-B-｜-C-｜
     * -A-｜-B-｜-C-｜
     * -A-｜-B-｜-D-｜
     * -A-｜-B-｜
     */
    class Solution {

        // 每种任务耗时1，再次执行有冷却时间n，求所有任务最快执行完成时间
        fun leastInterval(tasks: CharArray, n: Int): Int {
            // 根据冷却时间设计"桶"，有"单一种类最大的任务数量"的桶，每个桶的容量为1+n
            // 往桶里加任务不影响整体时间
            var maxTasks = 0
            var maxTaskCount = 0 // 拥有最多数量的任务种类数
            val alphabets = Array(26) {0}
            tasks.forEach {
                alphabets[it-'A']++
                maxTasks = maxOf(alphabets[it-'A'], maxTasks)
            }
            // 统计数量最多的任务种类个数
            alphabets.forEach {
                if (it == maxTasks) {
                    maxTaskCount++
                }
            }
            // 计算桶的耗时
            val total = (maxTasks - 1) * (n+1) + maxTaskCount
            // 另一种情况冷却时间很短，任务不需要等待可以连续执行，向桶里加入任务超出桶的容量
            // 耗时为tasks的长度

            return maxOf(tasks.size, total)
        }
    }
}