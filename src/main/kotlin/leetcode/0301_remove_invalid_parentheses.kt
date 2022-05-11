package leetcode

import kotlin.math.abs

//【回溯】【记忆化搜索】【dfs】
class _0301 {

    fun exec(s: String): List<String> {
        return Solution().removeInvalidParentheses(s)
    }

    // 输出删除最少字符使得左右括号数量相同的*所有组合*
    class Solution {
        // todo 逐个尝试删除

        // 方法1: 逐个尝试增加
        fun removeInvalidParentheses(s: String): List<String> {
            // 首先计算需要删除的左括号数或右括号数
            var left = 0
            var right = 0
            var others = 0
            for (char in s) {
                if (char == '(') {
                    left++
                } else if (char == ')') {
                    if (left > right) {
                        right++
                    }
                } else {
                    others++
                }
            }
            // 处理后的字符串长度为 s.length - left - right
            // 用dfs回溯穷举每一种可能的结果，如果左右括号数量不相等则丢弃

            // 用一个值统计步骤中的左右括号差值， 分数是正值，则只需删除(, 负值则只需删除)
            val result = HashSet<String>()
            val targetLength = others + 2 * minOf(left, right)
            dfs(s, 0, 0, targetLength, StringBuilder(), result)
            return result.toList()
        }


        // *score 既判断是否完成，也判断是否合法 score < 0表示有右括号先于左括号添加
        fun dfs(s: String, score: Int, index: Int, targetLength: Int, candidate: StringBuilder, collection: HashSet<String>) {
            if (candidate.length == targetLength) {
                if (score == 0) {
                    collection.add(candidate.toString())
                }
                return
            }
            if (candidate.length > targetLength || index >= s.length || score < 0) {
                return
            }
            when (s[index]) {
                '(' -> {
                    // 一个分支加上改字符，一个分支跳过
                    dfs(s, score+1, index+1, targetLength, StringBuilder(candidate).append('('), collection)
                    dfs(s, score, index+1, targetLength, candidate, collection)
                }
                ')' -> {
                    dfs(s, score-1, index+1, targetLength, StringBuilder(candidate).append(')'), collection)
                    dfs(s, score, index+1, targetLength, candidate, collection)
                }
                else -> {
                    dfs(s, score, index+1, targetLength, candidate.append(s[index]), collection)
                }
            }
        }
    }
}