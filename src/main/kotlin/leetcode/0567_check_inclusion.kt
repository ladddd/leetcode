package leetcode

class _0567: Case {

    override fun exec(args: Array<String>): Array<String> {
        if (args.size != 2) return emptyArray()
        return arrayOf(Solution().checkInclusion2(args[0], args[1]).toString())
    }

    class Solution {

        // s2一定比s1长，可能包含s1的所有元素(无视排序)
        fun checkInclusion(s1: String, s2: String): Boolean {
            if (s1.length > s2.length) {
                return false
            }

//            // 用两个数组统计每个字符出现的次数
//            val counter1 = Array(26) { _ -> 0}
//            val counter2 = Array(26) { _ -> 0}
//
//            // 如何判断s2的子串中完全包含s1？ s2子串和s1中每个字符的统计数量相同
//
//            // 滑动窗口，将窗口的宽度设置成s1的大小，录入字符数
//            for (i in s1.indices) {
//                ++counter1[s1[i] - 'a']
//                ++counter2[s2[i] - 'a']
//            }
//            if (counter1.contentEquals(counter2)) {
//                return true
//            }
//            // 开始向右滑动窗口
//            for (j in s1.length until s2.length) {
//                // 左边出右边进
//                ++counter2[s2[j] - 'a']
//                --counter2[s2[j - s1.length] - 'a']
//                if (counter1.contentEquals(counter2)) {
//                    // contentEqual会逐个比较字符集中每个元素，字符集越大越耗时
//                    // O(n) = m + n * k (字符集大小)
//                    return true
//                }
//            }

            // 将两个统计数组换成：一个统计数组 + 数量不一样的字符的数量
            // 这样时间复杂度可以降到 O(n) = m + n + k
            val counter = Array(26) { _ -> 0}
            var diff = 0

            for (i in s1.indices) {
                --counter[s1[i] - 'a']
                ++counter[s2[i] - 'a']
            }
            for (count in counter) {
                diff += if (count != 0) 1 else 0
            }
            if (diff == 0) {
                return true
            }
            for (j in s1.length until s2.length) {
                val left = s2[j - s1.length] - 'a'
                val right = s2[j] - 'a'

                if (left == right) continue

                if (counter[left] == 0) {
                    ++diff
                }
                --counter[left]
                // 计算后变0, diff - 1
                if (counter[left] == 0) {
                    --diff
                }
                if (counter[right] == 0) {
                    ++diff
                }
                ++counter[right]
                if (counter[right] == 0) {
                    --diff
                }
                if (diff == 0) {
                    return true
                }
            }

            return false
        }

        // 双指针
        fun checkInclusion2(s1: String, s2: String): Boolean {

            val counter = Array<Int>(26) { 0 }

            for (i in s1.indices) {
                // 初始化字符集数组，使里面的的统计值为-n
                --counter[s1[i] - 'a']
            }

            var left = 0
            for (right in s2.indices) {
                val rightChar = s2[right] - 'a'
                ++counter[rightChar]
                // 如果统计值 > 0，就让left指针向后移动，并将统计数-1，直到归0
                while (counter[rightChar] > 0) {
                    val leftChar = s2[left] - 'a'
                    --counter[leftChar]
                    left++
                }
                if (right - left + 1 == s1.length) {
                    return true
                }
            }

            return false
        }
    }
}