import leetcode.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class TestCases {

    private fun testCase(caseName: String, inputs: Array<*>, results: Array<*>) {
        val packageName = "leetcode"
        val className = "$packageName.$caseName"
        val case = Class.forName(className).getDeclaredConstructor().newInstance() as Case
        for (i in inputs.indices) {
            val caseInput = when (val input = inputs[i]) {
                is String -> arrayOf(input)
                is Array<*> -> input.map { it.toString() }.toTypedArray()
                else -> throw Exception("unsupported inputs type")
            }
            val caseOutput = case.exec(caseInput)
            val result = results[i]
            if (result is String) {
                // 比较一个元素
                assertEquals(result, caseOutput[0])
            } else if (result is Array<*>) {
                assertEquals(result.map {
                    it.toString()
                }.toTypedArray(), caseOutput)
            } else {
                throw Exception("unsupported output type")
            }
        }
    }

    @Test
    fun test0005() {
        testCase("_0005",
            arrayOf("abcb", "adda", "abcdd"),
            arrayOf("bcb", "adda", "dd")
        )
    }

    @Test
    fun test0014() {
        testCase("_0014",
            arrayOf(
                arrayOf("ab", "a"),
                arrayOf("flower","flow","flight"),
                arrayOf("dog","racecar","car")
            ),
            arrayOf("a", "fl", "")
        )
    }

    @Test
    fun test0567() {
        testCase("_0567",
            arrayOf(
                arrayOf("rokx", "otrxvfszxroxrzdsltg"),
                arrayOf("a", "ab"),
                arrayOf("ab", "eidboaoo")
            ),
            arrayOf("false", "true", "false")
        )
    }

    @Test
    fun test0043() {
        testCase("_0043",
            arrayOf(
                arrayOf("123", "456")
            ),
            arrayOf("56088")
        )
    }

    @Test
    fun test0151() {
        testCase("_0151",
            arrayOf(
                "the sky is blue",
                "  hello world  "
            ),
            arrayOf(
                "blue is sky the",
                "world hello"
            )
        )
    }
}