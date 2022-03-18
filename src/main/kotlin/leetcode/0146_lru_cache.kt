package leetcode

//【哈希】【链表】【数据结构】【LRU】
class _0146 {

    fun exec(): Boolean {
        val cache = LRUCache(2)
        var v2 = cache.get(2)
        cache.put(2, 6)
        var v1 = cache.get(1)
        cache.put(1,5)
        cache.put(1,2)
        v1 = cache.get(1)
        v2 = cache.get(2)
        return v1 == 2 && v2 == 6
    }

    // 双向队列
    // 访问：将访问到的元素调整到队头;
    // 插入：新元素从队头插入，队尾元素出队；
    class LRUCache(val capacity: Int) {
        val map = HashMap<Int, Int>()
        val deque = ArrayDeque<Int>() // ArrayDeque的性能比LinkedList要好（LinkedList的每次插入都需要动态扩容， 分配内存）

        fun get(key: Int): Int {
            val result = map.getOrElse(key) { return -1 }
            // 如果缓存里有，调整队列
            deque.remove(key)
            deque.addFirst(key)
            return result
        }

        fun put(key: Int, value: Int) {
            // 命中缓存
            if (map.containsKey(key)) {
                // 更新缓存值，将key移动到队头，不会超出缓存的容量
                deque.remove(key)
            } else {
                // 未命中缓存
                // 当前缓存已满, 队尾出队
                if (deque.size >= capacity) {
                    map.remove(deque.removeLast())
                }
            }
            deque.addFirst(key)
            map[key] = value
        }
    }
}