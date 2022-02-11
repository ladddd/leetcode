import leetcode._0005
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
}