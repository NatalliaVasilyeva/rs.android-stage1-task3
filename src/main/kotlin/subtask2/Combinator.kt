package subtask2

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {

        var numberOfPosters = array[0];
        var numberOfColors = array[1];

        if (numberOfPosters < 1 || numberOfColors <= 0) {
            return null;
        }

        var counts = arrayListOf<Int>();

        for (i in 1 until numberOfColors) {
            var countOfCombination = chooseCombinationCount(numberOfColors, i);

            if (numberOfPosters == countOfCombination) {
                counts.add(i);
            }
        }

        return if (counts.size ==0 || counts.min()==0) null else {
            counts.min()!!
        }
    }


    private fun chooseCombinationCount(n: Int, k: Int): Int {
        if (n == k) {
            return 1
        }
        return if (k == 1) {
            n
        } else
            chooseCombinationCount(n - 1, k) + chooseCombinationCount(n - 1, k - 1)
    }

}
