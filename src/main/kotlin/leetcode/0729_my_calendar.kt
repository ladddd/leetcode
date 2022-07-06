package leetcode

//【数组】【线段树】
class _0729 {
    class MyCalendar() {
        private val dated = ArrayList<Pair<Int, Int>>()

        fun book2(start: Int, end: Int): Boolean {
            if (dated.isEmpty()) {
                dated.add(Pair(start, end))
                return true
            }
            // 找插入的位置
            var insertIndex = 0
            while (insertIndex < dated.size && dated[insertIndex].first <= start) {
                insertIndex++
            }
            // 比较插入范围前后的数对
            for (i in insertIndex-1..insertIndex+1) {
                if (i !in dated.indices) {
                    continue
                }
                // 判断[start, end) 和 [dated[i].first, dated[i].second) 是否相交
                if (!((start >= dated[i].second)||(end <= dated[i].first))) {
                    return false
                }
            }
            dated.add(insertIndex, Pair(start, end))
            return true
        }

        // todo 线段树，动态开点
    }
}