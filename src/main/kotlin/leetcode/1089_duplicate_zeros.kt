package leetcode

//【数组】
class _1089 {
    class Solution {
        // 双指针
        fun duplicateZeros(arr: IntArray): Unit {
            var i = 0
            var j = 0
            // 第一遍遍历，将i定位到加0后的边界
            while (j < arr.size) {
                if (arr[i] == 0) j++
                i++
                j++
            }
            i-- // 定位到截断位置
            j--
            // 第2遍，将arr[j]赋值给arr[i]
            while (i >= 0) {
                // j可能-1后还比size大
                if (j < arr.size) {
                    arr[j] = arr[i]
                }
                // 如果这一位是0，说明是连续两个0，j多走一步，并将该位置为0
                if (arr[i] == 0 && j-1 >= 0) {
                    arr[j] = 0
                    j--
                }
                i--
                j--
            }
        }

        // 冒泡
        fun duplicateZeros2(arr: IntArray): Unit {
            for (i in arr.size-1 downTo 0) {
                if (arr[i] == 0) {
                    arr[arr.size-1] = 0
                    // 冒泡上去
                    for (j in arr.size-2 downTo i) {
                        arr[j+1] = arr[j]
                        arr[j] = 0
                    }
                }
            }
        }
    }
}