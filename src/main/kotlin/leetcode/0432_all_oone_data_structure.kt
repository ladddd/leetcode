package leetcode

//【哈希】【链表】【数据结构】【LFU】
class _0432 {

    fun exec(): Boolean {
        val allOne = AllOne()
        allOne.inc("a")
        allOne.inc("b")
        allOne.inc("b")
        allOne.inc("c")
        allOne.inc("c")
        allOne.inc("c")
        allOne.dec("b")
        allOne.dec("b")
        allOne.dec("a")
        return allOne.getMaxKey() == "c" && allOne.getMinKey() == "c"
    }

    // 字符串缓存
    // 变更记录、查询的复杂度均要求为O(1)
    // hashmap根据value查询key无法做到O(1)，考虑使用双向链表来维护字符串出现的次数
    // 考虑用空间换取时间
    class AllOne() {

        // 链表节点，维护increase n次的字符串列表
        class Node(var count: Int = 0) {
            var left: Node? = null
            var right: Node? = null
            val set = HashSet<String>() // inc了count次的字符串

            // 将自身移除队列
            fun remove() {
                left?.right = right
                right?.left = left
            }

            fun insert(count: Int, key: String): Node {
                val node = Node(count)
                node.set.add(key)
                if (count < this.count) {
                    var target = this
                    // 找到第一个相对小的值,插在前面
                    while ( count < target.count && target.right != null) {
                        target = target.right!!
                    }
                    node.left = target.left
                    target.left?.right = node
                    target.left = node
                    node.right = target
                } else {
                    var target = this
                    // 找到第一个相对大的值，插在后面
                    while (count > target.count && target.left != null) {
                        target = target.left!!
                    }
                    node.right = target.right
                    target.right?.left = node
                    target.right = node
                    node.left = target
                }
                return node
            }
        }

        // hashmap用于快速定位到某个节点
        val map = hashMapOf<String, Node>()
        // 双向链表的头尾哨兵，即允许从头或从尾开始遍历
        // *也可以做成一个循环队列
        val head = Node(Int.MAX_VALUE)
        val tail = Node(Int.MIN_VALUE)

        init {
            head.right = tail
            tail.left = head
        }

        fun clear() {
            map.clear()
            head.left?.right = head.right
        }

        fun inc(key: String) {
            if (map.containsKey(key)) {
                // 找到该节点
                val node = map[key]!!
                // 如果该节点的左侧node的count是该node的count+1，不需要插入节点操作
                if (node.left?.count == node.count + 1) {
                    node.left!!.set.add(key)
                    map[key] = node.left!!
                } else {
                    // 在左侧插入一个node.count + 1的节点
                    map[key] = node.insert(node.count + 1, key)
                }
                node.set.remove(key)
                if (node.set.isEmpty()) {
                    node.remove()
                }
            } else {
                // 该字符串不在链表中
                // 如果链表尾部的元素不为1，插入一个元素
                if (tail.right?.count != 1) {
                    map[key] = tail.insert(1, key)
                } else {
                    tail.right!!.set.add(key)
                    map[key] = tail.right!!
                }
            }
        }

        fun dec(key: String) {
            map[key]?.let { node ->
                if (node.count == 1) {
                    map.remove(key)
                } else {
                    if (node.right?.count == node.count - 1) {
                        node.right!!.set.add(key)
                        map[key] = node.right!!
                    } else {
                        map[key] = node.insert(node.count - 1, key)
                    }
                }
                node.set.remove(key)
                if (node.set.isEmpty()) {
                    node.remove()
                }
            }
        }

        // 任意一个最大计数字符串
        fun getMaxKey(): String {
            return head.right?.set?.firstOrNull() ?: ""
        }

        fun getMinKey(): String {
            return tail.left?.set?.firstOrNull() ?: ""
        }
    }

    /**
     * Your AllOne object will be instantiated and called as such:
     * var obj = AllOne()
     * obj.inc(key)
     * obj.dec(key)
     * var param_3 = obj.getMaxKey()
     * var param_4 = obj.getMinKey()
     */
}