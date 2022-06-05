package leetcode

//【字符串】
class _0929 {
    class Solution {
        fun numUniqueEmails(emails: Array<String>): Int {
            var set = HashSet<String>()
            for (email in emails) {
                val parts = email.split(",")
                if (parts.size != 2) continue

                var local = parts[0].split("\\+")[0]
                local = local.replace(".", "")
                val host = parts[1]
                set.add("${local}@${host}")
            }
            return set.size
        }
    }
}