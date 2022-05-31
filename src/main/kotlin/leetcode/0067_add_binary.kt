package leetcode

class _0067: Case {

    override fun exec(args: Array<String>): Array<String> {
        if (args.size < 2) return emptyArray()
        return arrayOf(Solution().addBinary(args[0], args[1]))
    }

    class Solution {
        fun addBinary(a: String, b: String): String {
            if (a.isEmpty()) return b
            if (b.isEmpty()) return a
            var p1 = a.length-1
            var p2 = b.length-1
            var carry = 0
            val result = StringBuilder()
            while (p1 >= 0 || p2 >= 0) {
                val value = ((a.getOrNull(p1)?:'0') - '0') + ((b.getOrNull(p2)?:'0') - '0') + carry
                carry = value/2
                result.insert(0, value%2)
                p1--
                p2--
            }
            if (carry > 0) {
                result.insert(0, 1)
            }
            return result.toString()
        }
    }
}