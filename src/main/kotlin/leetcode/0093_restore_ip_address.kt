package leetcode

import kotlin.math.max
import kotlin.math.min

//【递归】【回溯】【DFS-深度有限遍历】
class _0093: Case {

    override fun exec(args: Array<String>): Array<String> {
        return Solution().restoreIpAddresses(args.getOrElse(0) { return emptyArray() }).toTypedArray()
    }

    class Solution {

        var result = arrayListOf<String>()
        var segment = Array(4) { 0 }

        fun restoreIpAddresses(s: String): List<String> {
            dfs(s, 0, 0)
            return result
        }

        /**
         *
         */
        fun dfs(s: String, segmentIndex: Int, segmentStartPosition: Int) {
            if (segmentIndex == 4 || segmentStartPosition >= s.length) {
                if (segmentIndex == 4 && segmentStartPosition == s.length) {
                    result.add(segment.joinToString("."))
                }
                return
            }

            // 不能略过前导0, 否则就缺数字
            if (s[segmentStartPosition] == '0') {
                segment[segmentIndex] = 0
                dfs(s, segmentIndex + 1, segmentStartPosition + 1)
            }

            var addr = 0
            var segmentEndPosition = segmentStartPosition
            while (segmentEndPosition < s.length && segmentStartPosition - segmentEndPosition < 3) {
                addr = addr * 10 + (s[segmentEndPosition] - '0')
                // 剪枝，过滤掉不在范围内的结果 (此处不能为0, segment首部带0在上一步被滤掉)
                if (addr in 1..255) {
                    segment[segmentIndex] = addr
                    dfs(s, segmentIndex + 1, segmentEndPosition + 1)
                } else {
                    break
                }
                segmentEndPosition++
            }
        }
    }
}