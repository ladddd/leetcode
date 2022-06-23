package leetcode

//【字符串】【滑动窗口】
class _0030 {
    class Solution {
        // words 中单词的长度都是相同的
        fun findSubstring(s: String, words: Array<String>): List<Int> {
            val result = ArrayList<Int>()
            if (s.isEmpty() || words.isEmpty()) return result
            val single = words[0].length
            val total = words.size * single
            val map = hashMapOf<String, Int>()
            // 用hash表统计每个单词出现的次数
            for (word in words) {
                map[word] = (map[word] ?: 0) + 1
            }
            var startIndex = 0
            // 因为startIndex
            while (startIndex <= s.length - total) {
                val tempMap = hashMapOf<String, Int>()
                var tempIndex = startIndex
                while (tempIndex < startIndex + total) {
                    val key = s.substring(tempIndex, tempIndex + single)
                    tempMap[key] = (tempMap[key]?:0) + 1
                    tempIndex += single
                }
                // 比较tempMap和words map
                var equal = true
                for (key in map.keys) {
                    if (map[key] != tempMap[key]) {
                        equal = false
                        break
                    }
                }
                if (equal) {
                    result.add(startIndex)
                }
                startIndex++
            }
            return result
        }

        // todo 滑动窗口，不用临时map，用一个differ map存储words和s.subString的差异
//        for (word in words) {
//            differMap[word] = (differMap[word] ?: 0) + 1
//        }
//        for (j in words.indices) {
//            val key = s.substring(startIndex + j * single, startIndex + (j + 1) * single)
//            differMap[key] = (differMap[key] ?: 0) - 1
//        }

    }
}