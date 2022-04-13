package leetcode

//【回溯】
class _0022 {

    class Solution {

        // 穷举排列，想到回溯法
        // dfs遍历一棵二叉树
        fun generateParenthesis(n: Int): List<String> {
            val result = arrayListOf<String>()
            backtrace(result, StringBuilder(), 0, 0, n)
            return result
        }

        // open 表示当前左括号的数量 close 表示当前右括号的数量
        fun backtrace(combinations: ArrayList<String>, combination: StringBuilder, open: Int, close: Int, max: Int) {
            if (combination.length == max*2) {
                combinations.add(combination.toString())
            }
            // 如果左括号数量不大于 n，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号。
            if (open < max) {
                combination.append("(")
                backtrace(combinations, combination, open+1, close, max)
                combination.deleteCharAt(combination.length-1)
            }
            if (close < open) {
                combination.append(")")
                backtrace(combinations, combination, open, close+1, max)
                combination.deleteCharAt(combination.length-1)
            }
        }
    }
}