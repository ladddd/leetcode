package leetcode

import java.lang.StringBuilder

interface Case {
    fun exec(args: Array<String>): Array<String>
}

interface Executable<In, Out> {
    fun exec(args: Array<In>): Array<Out>
}

interface ListNodeCase : Executable<ListNode, ListNode>

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    var cycle = false // 手动标记环入口，在创建时设置

    override fun equals(other: Any?): Boolean {
        return toString() == other.toString()
    }

    override fun hashCode(): Int {
        return toString().hashCode()
    }

    // 展开成数组
    fun toArray(): Array<Int> {
        val list = ArrayList<Int>()
        var temp: ListNode? = this
        var visited = false
        while (temp != null) {
            if (temp.cycle) {
                if (visited) {
                    break
                }
                visited = true
            }
            list.add(temp.`val`)
            temp = temp.next
        }
        return list.toTypedArray()
    }

    override fun toString(): String {
        val sb = StringBuilder()
        var temp: ListNode? = this
        // 考虑有环的情况，单链表至多只有一个环
        var visited = false
        while (temp != null) {
            if (temp.cycle) {
                if (visited) {
                    break
                }
                visited = true
            }
            sb.append("${temp.`val`},")
            temp = temp.next
        }
        return sb.removeSuffix(",").toString()
    }

    fun get(index: Int): ListNode? {
        var temp: ListNode? = this
        for (i in 0 until index) {
            if (temp == null) {
                return null
            }
            temp = temp.next
        }
        return temp
    }

    // 提供一个通过数组创建链表的方式
    companion object {

        fun cycleListFromString(str: String, entranceIndex: Int, delimiters: String = ","): ListNode? {
            val parts = str.split(delimiters)
            if (parts.isNullOrEmpty()) return null
            return cycleListFromArray(parts.map { it.toInt() }.toTypedArray(), entranceIndex)
        }

        fun cycleListFromArray(array: Array<Int>, entranceIndex: Int): ListNode? {
            if (array.isEmpty()) return null
            val head = ListNode(array[0])
            var temp = head
            var entrance: ListNode? = null
            for (i in 1 until array.size) {
                temp.next = ListNode(array[i])
                temp = temp.next!!
                if (i == entranceIndex) {
                    temp.cycle = true
                    entrance = temp
                }
            }
            entrance.let {
                temp.next = it
            }
            return head
        }

        fun fromString(str: String, delimiters: String = ","): ListNode? {
            val parts = str.split(delimiters)
            if (parts.isNullOrEmpty()) return null
            return fromArray(parts.map { it.toInt() }.toTypedArray())
        }

        fun fromArray(array: Array<Int>): ListNode? {
            if (array.isEmpty()) return null
            val head = ListNode(array[0])
            var temp = head
            for (i in 1 until array.size) {
                temp.next = ListNode(array[i])
                temp = temp.next!!
            }
            return head
        }
    }
}

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}