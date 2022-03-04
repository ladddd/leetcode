package leetcode

import java.lang.StringBuilder

interface Case {
    fun exec(args: Array<String>): Array<String>
}

interface Executable<In, Out> {
    fun exec(args: Array<In>): Array<Out>
}

interface ListNodeCase: Executable<ListNode, ListNode>

class ListNode(var `val`: Int) {
    var next: ListNode? = null

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
        while (temp != null) {
            list.add(temp.`val`)
            temp = temp.next
        }
        return list.toTypedArray()
    }

    override fun toString(): String {
        val sb = StringBuilder()
        var temp: ListNode? = this
        while (temp != null) {
            sb.append("${temp.`val`},")
            temp = temp.next
        }
        return sb.removeSuffix(",").toString()
    }

    // 提供一个通过数组创建链表的方式
    companion object {

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