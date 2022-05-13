package leetcode

//【图】【带权并查集】【联合查找】
class _0399 {

    fun exec(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): Int {
        val result = Solution().calcEquation(equations, values, queries)
        return -1
    }

    class Solution {

        // 将所有可能的倍数关系合并，统一单位
        fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
            // 用邻接表构建图
            // 为了增加查询的速度，需要压缩变量：a = 2c b = 2a, 按标准构建有2层，如果将b=2a转化为b=4c，则只有一层
            // 哈希表所有参与运算的变量 变量，序号
            val variables = hashMapOf<String, Int>()
            var varIndex = 0
            for (equation in equations) {
                if (!variables.contains(equation[0])) {
                    variables[equation[0]] = varIndex++
                }
                if (!variables.contains(equation[1])) {
                    variables[equation[1]] = varIndex++
                }
            }
            // 初始化变量和倍数关系
            val replacements = Array(varIndex) { i -> i } // 初始值为各变量自身，没有替换
            val times = Array(varIndex) { 1.0 } // 因为是自身，是1倍
            // 压缩
            for (i in equations.indices) {
                merge(replacements, times, variables[equations[i][0]]!!, variables[equations[i][1]]!!, values[i])
            }
            // 查找
            val result = DoubleArray(queries.size)
            for (j in queries.indices) {
                var ret = -1.0
                // 请求中的变量可能不在条件集合内，判断一下
                if (variables.contains(queries[j][0]) && variables.contains(queries[j][1])) {
                    val originalA = variables[queries[j][0]]!!
                    val originalB = variables[queries[j][1]]!!
                    val replacementA = findReplacement(replacements, times, originalA)
                    val replacementB = findReplacement(replacements, times, originalB)
                    // 基底相同，两者有倍数关系
                    if (replacementA == replacementB) {
                        ret = times[originalA] / times[originalB]
                    }
                }
                result[j] = ret
            }
            return result
        }

        fun merge(replacements: Array<Int>, times: Array<Double>, var1: Int, var2: Int, value: Double) {
            val r1 = findReplacement(replacements, times, var1)
            val r2 = findReplacement(replacements, times, var2)
            // 用var2表示var1
            replacements[r1] = r2
            times[r1] = value * times[var2] / times[var1]
        }

        fun findReplacement(replacements: Array<Int>, times: Array<Double>, var1: Int): Int {
            if (replacements[var1] != var1) {
                // 该变量已经用其他变量替换掉了, 递归查找最终的基底
                val replacement = findReplacement(replacements, times, replacements[var1])
                times[var1] = times[var1] * times[replacements[var1]] // 调整var1被替换后的倍率
                replacements[var1] = replacement
            }
            return replacements[var1]
        }

        // todo bfs
    }
}