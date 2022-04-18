package leetcode

//【数组】【哈希】
class _0049 {

    class Solution {

        // 将排序后的字母组合作为键值
        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            val map = HashMap<String, ArrayList<String>>()
            val result = ArrayList<ArrayList<String>>()
            for (str in strs) {
                // 这边还可以用计数的方式做键
                // val counter = Array(26) 统计每个字母出现的次数
                val key = str.toCharArray().sorted().toString()
                if (map[key] == null) {
                    map[key] = arrayListOf(str)
                } else {
                    map[key]!!.add(str)
                }
            }
            for (key in map.keys) {
                map[key]?.let {
                    result.add(it)
                }
            }
            return result
        }
    }
}