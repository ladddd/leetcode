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
            } else if (result is Number) {
                assertEquals(result.toString(), caseOutput[0])
            } else if (result is Array<*>) {
                val sortedResult = result.map {
                    it.toString()
                }.toTypedArray().sortedArray()
                val sortedOutput = caseOutput.sortedArray()
                val isEqual = sortedResult.contentEquals(sortedOutput)
                assertEquals(true, isEqual, "expected: ${sortedResult.contentToString()} \nactual: ${sortedOutput.contentToString()}\n")
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

    @Test
    fun test0071() {
        testCase("_0071",
            arrayOf("/home//foo/", "/../", "/home/"),
            arrayOf("/home/foo", "/", "/home")
        )
    }

    @Test
    fun test0093() {
        testCase("_0093",
            arrayOf("101023", "0000", "25525511135"),
            arrayOf(
                arrayOf("1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"),
                arrayOf("0.0.0.0"),
                arrayOf("255.255.11.135", "255.255.111.35"),
            )
        )
    }

    @Test
    fun test0015() {
        testCase("_0015",
            arrayOf(
                arrayOf(),
                arrayOf(0),
                arrayOf(-1,0,1,2,-1,-4)
            ),
            arrayOf(
                arrayOf(),
                arrayOf(),
                arrayOf("[-1,-1,2]", "[-1,0,1]")
            )
        )
    }

    @Test
    fun test0685() {
        val case = _0695()
        val result = case.exec(arrayOf(
            intArrayOf(0,0,1,0,0,0,0,1,0,0,0,0,0),
            intArrayOf(0,0,0,0,0,0,0,1,1,1,0,0,0),
            intArrayOf(0,1,1,0,1,0,0,0,0,0,0,0,0),
            intArrayOf(0,1,0,0,1,1,0,0,1,0,1,0,0),
            intArrayOf(0,1,0,0,1,1,0,0,1,1,1,0,0),
            intArrayOf(0,0,0,0,0,0,0,0,0,0,1,0,0),
            intArrayOf(0,0,0,0,0,0,0,1,1,1,0,0,0),
            intArrayOf(0,0,0,0,0,0,0,1,1,0,0,0,0),
        ))
        assertEquals(6, result)
    }

    @Test
    fun test0033() {
        val case = _0033()
        val result = case.exec(
            intArrayOf(4,5,6,7,0,1,2),
            3
        )
        assertEquals(-1, result)
    }

    @Test
    fun test0674() {
        testCase("_0674",
            arrayOf(
                arrayOf(1,3,5,7)
            ),
            arrayOf(4)
        )
    }

    @Test
    fun test0215() {
        val case = _0215()
        val result = case.exec(
            intArrayOf(3,2,1,5,6,4),
            2
        )
        assertEquals(5, result)
    }

    @Test
    fun test0128() {
        testCase("_0128",
            arrayOf(
                arrayOf(4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3),
                arrayOf(100,4,200,1,3,2),
                emptyArray()
            ),
            arrayOf(
                5,
                4,
                0
            )
        )
    }

    @Test
    fun test0060() {
        testCase("_0060",
            arrayOf(
                arrayOf(3, 3),
                arrayOf(4, 9)
            ),
            arrayOf(
                "213",
                "2314"
            )
        )
    }

    @Test
    fun test0547() {
        val case = _0547()
        val result = case.exec(arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
//            intArrayOf(1, 1, 1, 1, 1),
//            intArrayOf(1, 1, 1, 1, 1),
//            intArrayOf(1, 1, 1, 1, 1),
//            intArrayOf(1, 1, 1, 1, 1),
//            intArrayOf(1, 1, 1, 1, 1),
        ))
        assertEquals(1, result)
    }

    @Test
    fun test0056() {
        val case = _0056()
        val output = case.exec(arrayOf(
//            intArrayOf(1,3),
//            intArrayOf(2,6),
//            intArrayOf(8,10),
//            intArrayOf(15,18),
            intArrayOf(1,4),
            intArrayOf(0,1),
        ))
        val outputStr = output.joinToString(",","[","]",-1,"") {
            it.contentToString()
        }
        val result = arrayOf(
//            intArrayOf(1,6),
//            intArrayOf(8,10),
//            intArrayOf(15,18),
            intArrayOf(0,4)
        )
        val resultStr = result.joinToString(",","[","]",-1,"") {
            it.contentToString()
        }
        assertEquals(outputStr, resultStr)
    }
}