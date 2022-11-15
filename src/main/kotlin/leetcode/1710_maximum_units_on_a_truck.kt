package leetcode

//【贪心】
class _1710{

    class Solution {
        // boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]
        // 给定卡车运载最大箱子数量 truckSize，求能运送的最大Unit数量
        fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
            var remain = truckSize
            var result = 0
            for (box in boxTypes.sortedByDescending { it[1] }) {
                result += box[1] * minOf(box[0], remain)
                remain -= minOf(box[0], remain)
                if (remain <= 0) {
                    break
                }
            }
            return result
        }
    }
}