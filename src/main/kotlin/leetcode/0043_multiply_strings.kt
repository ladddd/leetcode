package leetcode

class _0043: Case {

    override fun exec(args: Array<String>): Array<String> {
        if (args.size != 2) return emptyArray()
        val solution = Solution()
        return arrayOf(solution.multiply(args[0], args[1]))
    }

    class Solution {

        // 求乘积 竖式 O(n) = m * n
        fun multiply(num1: String, num2: String): String {
            if (num1.isEmpty() || num2.isEmpty()) {
                return "0"
            }
            if (num1 == "0" || num2 == "0") {
                return "0"
            }
            // num1.length + num2.length 长度就行
            val result = Array(num1.length + num2.length) {0}
            for (i in num1.length - 1 downTo 0) {
                val n1 = num1[i] - '0'
                for (j in num2.length - 1 downTo 0) {
                    val n2 = num2[j] - '0'
                    val temp = result[i + j + 1] + n1 * n2
                    result[i + j + 1] = temp % 10 // num1[i] * num2[j] 在竖式中的位置是 i + j + 1 (套初始值可推断 i == num1.length - 1, j == num2.length - 1 ==> num1.length + num2.length - 1)
                    result[i + j] += temp / 10 // 加上进位
                }
            }
            val sb = StringBuilder()
            for (num in result) {
                if (sb.isEmpty() && num == 0) continue
                sb.append(num)
            }
            return sb.toString()
        }
    }
}