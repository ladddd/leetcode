package leetcode

import sun.security.provider.certpath.AdjacencyList

//【图】【拓扑排序】【环检测】
class _0207 {
    class Solution {
        // 有向图的环检测，如果有环，代表课程间依赖关系死循环

        // 方法2 dfs环检测
        // * 都需要建立一张邻接表
        fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
            // 为每个课程新建一个邻接表(存放后置的课程)
            val adjacencyList = ArrayList<ArrayList<Int>>()
            for (i in 0 until numCourses) {
                adjacencyList.add(ArrayList())
            }
            // 遍历课程关系，初始化各课程的邻接表
            for (prerequisite in prerequisites) {
                // 第一位是果节点 [1,2]表示修1必须先修2
                adjacencyList[prerequisite[1]].add(prerequisite[0])
            }
            // 对每个节点做环检测
            val flags = Array(numCourses) {0}
            for (i in 0 until numCourses) {
                // 检测到环，return false
                if (!dfs(adjacencyList, flags, i)) return false
            }
            return true
        }

        // flags: 1：被起点dfs访问过 -1：被其他dfs访问过 0：未访问过
        fun dfs(adjacencyList: List<List<Int>>, flags: Array<Int>, course:Int): Boolean {
            when (flags[course]) {
                1 -> return false // 在这次dfs中已被访问，说明有环
                -1 -> return true
                else -> {
                    flags[course] = 1
                    for (next in adjacencyList[course]) {
                        if (!dfs(adjacencyList, flags, next)) return false
                    }
                    flags[course] = -1
                    return true
                }
            }
        }

        // 方法1，用入度表统计每个课程的入度
        fun canFinish2(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
            val inDegrees = Array<Int>(numCourses) { 0 } // 课程的入度
            // 为每个课程新建一个邻接表(存放后置的课程)
            val adjacencyList = ArrayList<ArrayList<Int>>()
            for (i in 0 until numCourses) {
                adjacencyList.add(ArrayList())
            }
            // 遍历课程关系，初始化各课程的邻接表和入度
            for (prerequisite in prerequisites) {
                // 第一位是果节点 [1,2]表示修1必须先修2
                // 加入度
                inDegrees[prerequisite[0]]++
                adjacencyList[prerequisite[1]].add(prerequisite[0])
            }
            // 将入度为0的课加入队列中
            val queue = ArrayDeque<Int>()
            for (i in 0 until numCourses) {
                if (inDegrees[i] == 0) {
                    queue.addLast(i)
                }
            }
            var coursesForStudy = numCourses
            while (queue.isNotEmpty()) {
                val pre = queue.removeFirst()
                // 学习该课程
                coursesForStudy--
                // 将该课程后置课入度减1
                for (cur in adjacencyList[pre]) {
                    if (--inDegrees[cur] == 0) {
                        queue.addLast(cur)
                    }
                }
            }
            return coursesForStudy == 0
        }
    }
}