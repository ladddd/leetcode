import leetcode._0005
import leetcode._0014
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
}