package leetcode

class _0017: Case {

    override fun exec(args: Array<String>): Array<String> {
        if (args.isEmpty()) return emptyArray()
        return Solution().letterCombinations(args[0]).toTypedArray()
    }

    class Solution {
        fun letterCombinations(digits: String): List<String> {
            // todo
            return emptyList()
        }
    }
}