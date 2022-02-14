import leetcode._0005
import leetcode._0014
import leetcode._0043
import leetcode._0567
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class TestCases {

    @Test
    fun test0005() {
        val case = _0005()
        val inputs = arrayOf("abcb", "adda", "abcdd")
        val results = arrayOf("bcb", "adda", "dd")
        for (i in inputs.indices) {
            assertEquals(case.exec(arrayOf(inputs[i])).getOrNull(0), results[i])
        }
    }

    @Test
    fun test0014() {
        val case = _0014()
        val inputs = arrayOf(
            arrayOf("ab", "a"),
            arrayOf("flower","flow","flight"),
            arrayOf("dog","racecar","car")
        )
        val results = arrayOf("a", "fl", "")
        for (i in inputs.indices) {
            assertEquals(case.exec(inputs[i]).getOrNull(0), results[i])
        }
    }

    @Test
    fun test0567() {
        val case = _0567()
        val inputs = arrayOf(
            arrayOf("rokx", "otrxvfszxroxrzdsltg"),
            arrayOf("a", "ab"),
            arrayOf("ab", "eidboaoo")
        )
        val result = arrayOf("false", "true", "false")
        for (i in inputs.indices) {
            assertEquals(case.exec(inputs[i]).getOrNull(0), result[i])
        }
    }

    @Test
    fun test0043() {
        val case = _0043()
        val inputs = arrayOf(
            arrayOf("123", "456")
        )
        val result = arrayOf("56088")
        for (i in inputs.indices) {
            assertEquals(case.exec(inputs[i]).getOrNull(0), result[i])
        }
    }
}