package leetcode

class _0648 {
    class Solution {
        fun replaceWords(dictionary: List<String>, sentence: String): String {
            val words = sentence.split(" ") as ArrayList
            if (words.isEmpty()) {
                return sentence
            }
            val sorted = dictionary.sortedBy { it.length }
            for (i in words.indices) {
                for (j in sorted.indices) {
                    if (sorted[j].length > words[i].length) {
                        break
                    }
                    if (words[i].startsWith(sorted[j])) {
                        words[i] = sorted[j]
                        break
                    }
                }
            }
            return words.joinToString(" ")
        }

        // todo 用前缀树
    }
}