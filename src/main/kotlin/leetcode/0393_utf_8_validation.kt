package leetcode

//【位运算】【数据结构】【贪心】
@Suppress("unused", "ClassName")
class _0393: Case {

    override fun exec(args: Array<String>): Array<String> {
        if (args.isEmpty()) return emptyArray()
        return arrayOf(Solution().validUtf8(args.map { it.toInt() }.toIntArray()).toString())
    }

    // 找出匹配utf-8编码的字符（它可以是单字节的，也可能是多子节的）
    // utf-8的编码规范
    //   Char. number range  |        UTF-8 octet sequence
    //      (hexadecimal)    |              (binary)
    //   --------------------+---------------------------------------------
    //   0000 0000-0000 007F | 0xxxxxxx
    //   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
    //   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
    //   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/utf-8-validation
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    class Solution {

        // 标准的utf-8编码, 一个字符包含1-4个字节byte
        // 本题可能包含多个字符
        // data的长度代表该编码的字节数
        // 依次校验各字节开头若干位bit是否符合规范
        fun validUtf8(data: IntArray): Boolean {
            var i = 0
            while (i < data.size) {
                // 每次遍历寻找一个字符（1-4字节）
                // 第一个字符确定包含的字节数
                val first = data[i]
                var index = 7 // 从最高位开始统计1的个数, 找到第一个不为1的位
                // 左移 + 与一 或取第index位bit
                while (index >= 0 && (first shr index and 1) == 1) index--
                val cnt = 7 - index
                // 0 2 3 4 合法
                if (cnt !in 2..4 && cnt != 0) return false
                // 尾部字符长度不够的也淘汰
                if (i + cnt - 1 >= data.size) return false
                // 校验该字符剩余 cnt - 1 个字节
                for (k in i+1 until i+cnt) {
                    // 判断是否是'10'开头
                    if (data[k] shr 7 and 1 != 1 || data[k] shr 6 and 1 != 0) {
                        return false
                    }
                }
                if (cnt == 0) i++ // 单字节
                i += cnt
            }
            return true
        }
    }
}