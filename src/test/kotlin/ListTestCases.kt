import leetcode.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

// 链表用例
@RunWith(JUnit4::class)
class ListTestCases {

    private fun testListNodeCase(caseName: String, inputs: Array<Array<ListNode>>, results: Array<Array<ListNode>>) {
        val listNodeCase = Class.forName("leetcode.$caseName").getDeclaredConstructor().newInstance() as? ListNodeCase
            ?: throw java.lang.AssertionError("case $caseName is not inherit from ListNodeCase")
        for (i in inputs.indices) {
            val output = listNodeCase.exec(inputs[i])
            val isEqual = output.contentEquals(results[i])
            assertEquals(true, isEqual, "expected: ${results[i].contentToString()} \nactual: ${output.contentToString()}\n")
        }
    }

    @Test
    fun test0021() {
        testListNodeCase("_0021",
            arrayOf(
                arrayOf(ListNode.fromString("1,2,4")!!, ListNode.fromString("1,3,4")!!)
            ),
            arrayOf(
                arrayOf(ListNode.fromString("1,1,2,3,4,4")!!)
            )
        )
    }

    @Test
    fun test0206() {
        testListNodeCase("_0206",
            arrayOf(
                arrayOf(ListNode.fromString("1,2,3,4,5")!!)
            ),
            arrayOf(
                arrayOf(ListNode.fromString("5,4,3,2,1")!!)
            )
        )
    }

    @Test
    fun test0002() {
        testListNodeCase("_0002",
            arrayOf(
                arrayOf(ListNode.fromString("9,9,9,9,9,9,9")!!, ListNode.fromString("9,9,9,9")!!),
                arrayOf(ListNode.fromString("2,4,3")!!, ListNode.fromString("5,6,4")!!)
            ),
            arrayOf(
                arrayOf(ListNode.fromString("8,9,9,9,0,0,0,1")!!),
                arrayOf(ListNode.fromString("7,0,8")!!)
            )
        )
    }

    @Test
    fun test0148() {
        testListNodeCase("_0148",
            arrayOf(arrayOf(ListNode.fromString("-1,5,3,4,0")!!)),
            arrayOf(arrayOf(ListNode.fromString("-1,0,3,4,5")!!))
        )
    }

    @Test
    fun test0142() {
        val head = ListNode.cycleListFromString("3,2,0,-4", 1)!!
        testListNodeCase("_0142",
            arrayOf(arrayOf(head)),
            arrayOf(arrayOf(head.get(1)!!))
        )
    }

    @Test
    fun test0160() {
        val list1 = ListNode.fromString("4,1,8,4,5")
        val list2 = ListNode.fromString("5,6,1")
        list2?.get(2)?.next = list1?.get(2)
        list2?.get(3)?.next = ListNode.fromString("4,5")
        testListNodeCase("_0160",
            arrayOf(arrayOf(list1!!, list2!!)),
            arrayOf(arrayOf(ListNode.fromString("8,4,5")!!))
        )
    }

    @Test
    fun test0023() {
        // [1,4,5],[1,3,4],[2,6]
        testListNodeCase("_0023",
            arrayOf(
                arrayOf(
                    ListNode.fromString("1,4,5")!!,
                    ListNode.fromString("1,3,4")!!,
                    ListNode.fromString("2,6")!!,
                )
            ),
            arrayOf(
                arrayOf(
                    ListNode.fromString("1,1,2,3,4,4,5,6")!!,
                )
            )
        )
    }

    @Test
    fun test0234() {
        val list = ListNode.fromString("1")
        val result = _0234().exec(list)
        assertEquals(true, result)
    }
}