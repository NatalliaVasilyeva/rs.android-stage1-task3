package subtask6


class FullBinaryTrees {

    class Node(var value: Int = 0) {
        var leftNode: Node? = null;
        var rightNode: Node? = null;

    }

    fun stringForNodeCount(count: Int): String {
        val binaryTreeCombinations = takeAllBinaryTreeCombination(count)
        val result = mutableListOf<MutableList<Int?>>()
        for (node in binaryTreeCombinations) {
            val stateOfNode = createStateOfNode(node!!)
            while (stateOfNode[stateOfNode.size - 1] == null) {
                stateOfNode.removeAt(stateOfNode.size - 1)
            }
            result.add(stateOfNode)
        }
        return result.toString()

    }

    private fun takeAllBinaryTreeCombination(count: Int): ArrayList<Node?> {
        if (count == 1) return arrayListOf(Node(0))
        if (count % 2 == 0) return ArrayList()
        var list = ArrayList<Node?>()
        for (i in 0 until count) {
            for (left in takeAllBinaryTreeCombination(i)) {
                for (right in takeAllBinaryTreeCombination(count - i - 1)) {
                    var node = Node(0);
                    node.leftNode = left;
                    node.rightNode = right;
                    list.add(node);
                }
            }
        }
        return list;
    }

    private fun createStateOfNode(node: Node): ArrayList<Int?> {
        var level = 0
        val resultArray = arrayListOf<Int?>(0)
        val nodeChildren = arrayListOf(node.leftNode, node.rightNode)
        while (nodeChildren.isNotEmpty()) {
            var grandChildren = arrayListOf<Node?>();
            for (child in nodeChildren) {
                if (child == null && level != node.value) {
                    resultArray.add(null);
                } else if (child != null) {
                    resultArray.add(0);
                    grandChildren.add(child?.leftNode);
                    grandChildren.add(child?.rightNode);
                }
            }
            level++;
            nodeChildren.clear();
            nodeChildren.addAll(grandChildren);
            grandChildren.clear();
        }

        return resultArray;
    }
}
