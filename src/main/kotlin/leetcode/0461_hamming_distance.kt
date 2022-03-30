package leetcode

//【位运算】
class _0461 {

    // 汉明距离，两个数二进制位不相同的个数
    class Solution {

        // 一直右移直到两数异或为0（二进制相同）
        fun hammingDistance(x: Int, y: Int): Int {
            var count = 0
            var z = x xor y
//            while (z != 0) {
//                count += z and 1 // 判断最低位是否为1
//                z = z shr 1
//            }

            // 用Brian Kernighan算法减少判断次数
            while (z != 0) {
                z = z and (z - 1)
                count++
            }

            return count
        }



    }
}