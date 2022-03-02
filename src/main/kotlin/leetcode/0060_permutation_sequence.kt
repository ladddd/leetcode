package leetcode

import java.lang.StringBuilder

//【回溯】【康托展开】【DFS】【逆康托展开】
class _0060: Case {

    override fun exec(args: Array<String>): Array<String> {
        val n = args.getOrElse(0) { return emptyArray() }.toInt()
        val k = args.getOrElse(1) { return emptyArray() }.toInt()
        return arrayOf(Solution().getPermutation(n, k))
    }

    class Solution {

        // 在 n! 种排列中找出第 k 大的值
        // 1.使用逆康托展开
        // 公式：[https://zh.wikipedia.org/wiki/%E5%BA%B7%E6%89%98%E5%B1%95%E5%BC%80]
        fun getPermutation(n: Int, k: Int): String {
            val factorialArray = calculateFactorial(n)
            val sb = StringBuilder()
            // 用一个数组保存使用过的数字
            val used = BooleanArray(n)
            // 第k个数之前的排列组合数为 k - 1 个
            var tempK = k - 1
            for (i in n-1 downTo 0) {
                val a = tempK / factorialArray[i] // 第n-1位有a个数比该位数字小，factorialArray[i]得到的是i-1的阶乘
                tempK -= a * factorialArray[i]
                // 找到未使用的第a+1个数填充该位
                var count = 0
                for (j in used.indices) {
                    if (!used[j]) {
                        if (count == a) {
                            sb.append(j+1)
                            used[j] = true
                            break
                        }
                        count++
                    }
                }
            }
            return sb.toString()
        }

        // 计算阶乘数组（0 - n-1的阶乘）
        fun calculateFactorial(n: Int): IntArray {
            val result = IntArray(n)
            result[0] = 1
            for (i in 1 until n) {
                result[i] = result[i-1] * i
            }
            return result
        }

        // ##################################################
        val list = arrayListOf<String>() // 所有排列集合

        // 2.回溯穷举所有的排列，选取第k-1个
        fun getPermutation2(n: Int, k: Int): String {
            backTracing(0, n, StringBuilder())
            return list[k - 1]
        }

        //
        fun backTracing(index: Int, size: Int, builder: StringBuilder) {
            if (index >= size) {
                list.add(builder.toString())
                return
            }
            for (i in 1..size) {
                if (!builder.toString().contains("$i")) {
                    builder.append("$i")
                    backTracing(index + 1, size, builder)
                    // 回退该位，完成这一位（index）的遍历
                    builder.deleteCharAt(builder.length - 1)
                }
            }
        }
    }
}