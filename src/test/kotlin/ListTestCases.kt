import leetcode.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

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
}