package leetcode

//【数组】【回溯】
class _0017: Case {

    override fun exec(args: Array<String>): Array<String> {
        if (args.isEmpty()) return emptyArray()
        return Solution().letterCombinations(args[0]).toTypedArray()
    }

    class Solution {
        fun letterCombinations(digits: String): List<String> {
            // 构建键盘字符的哈希表
            val map = hashMapOf(
                '2' to "abc",
                '3' to "def",
                '4' to "hgi",
                '5' to "jkl",
                '6' to "mno",
                '7' to "pqrs",
                '8' to "tuv",
                '9' to "wxyz",
            )
            // 使用回溯穷举所有组合
            val result = arrayListOf<String>()
            if (digits.isNotEmpty()) {
                backtrace(result, map, digits, 0, StringBuilder())
            }
            return result
        }

        fun backtrace(combinations: ArrayList<String>, letterMap: Map<Char, String>, digits: String, index: Int, combination: StringBuilder) {
            if (index == digits.length) {
                combinations.add(combination.toString())
            } else {
                val char = digits[index]
                val letters = letterMap[char]
                letters?.forEach {
                    combination.append(it)
                    backtrace(combinations, letterMap, digits, index+1, combination)
                    combination.deleteCharAt(index)
                }
            }
        }
    }
}