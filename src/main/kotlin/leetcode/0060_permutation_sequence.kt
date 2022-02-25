package leetcode

import java.lang.StringBuilder

//【回溯】【康托展开】【DFS】
class _0060: Case {

    override fun exec(args: Array<String>): Array<String> {
        val n = args.getOrElse(0) { return emptyArray() }.toInt()
        val k = args.getOrElse(1) { return emptyArray() }.toInt()
        return arrayOf(Solution().getPermutation2(n, k))
    }

    class Solution {

        // 在 n! 种排列中找出第 k 大的值
        fun getPermutation(n: Int, k: Int): String {
            val factorialArray = calculateFactorial(n)
            return ""
        }

        // 计算阶乘数组（1 - 9的阶乘）
        fun calculateFactorial(n: Int): IntArray {
            val result = IntArray(n)
            result[0] = 1
            for (i in 1 until n) {
                result[i] = result[i-1] * (i+1)
            }
            return result
        }


        val list = arrayListOf<String>() // 所有排列集合

        // 穷举所有的排列，选取第k-1个
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