package leetcode

//【树】
class _0208 {

    // 前缀树的特征 children isEnd
    class Trie() {
        private val children: Array<Trie?> = Array(26) { null }
        private var isEnd = false

        fun insert(word: String) {
            // 从当前节点开始查找前缀
            var node = this
            for (i in word.indices) {
                val index = word[i] - 'a'
                // 如果没有前缀就创建
                if (node.children[index] == null) {
                    node.children[index] = Trie()
                }
                node = node.children[index]!!
            }
            node.isEnd = true
        }

        fun search(word: String): Boolean {
            return searchWithPrefix(word)?.isEnd == true
        }

        fun startsWith(prefix: String): Boolean {
            return searchWithPrefix(prefix) != null
        }

        fun searchWithPrefix(prefix: String): Trie? {
            var node = this
            for (i in prefix.indices) {
                val index = prefix[i] - 'a'
                if (node.children[index] == null) {
                    return null
                } else {
                    node = node.children[index]!!
                }
            }
            return node
        }

    }
}