package subtask3

import kotlin.math.absoluteValue


class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var multiplication = 1;
        var sortedArray =
            itemsFromArray.filterIsInstance<Int>().sortedByDescending { it.absoluteValue };
        val positiveIntArray = sortedArray.filter { i -> i > 0 }
        var negativeIntArray = sortedArray.filter { i -> i < 0 }
        var allNumbersMultiplication = 1
        var positiveNumberMultiplication = 1;


        if (sortedArray.size <= numberOfItems) {
            if (sortedArray.isEmpty()) {
                return 0;
            } else {
                sortedArray.indices.forEach { i ->
                    multiplication *= sortedArray[i];
                }
            }
            return multiplication;
        }

        if (negativeIntArray.size <= 1) {
            for (i in 0 until numberOfItems) {
                multiplication *= positiveIntArray[i];
            }
            return multiplication;
        }

        for (i in 0 until numberOfItems) {
            allNumbersMultiplication *= sortedArray[i];
            positiveNumberMultiplication *= positiveIntArray[i];
        }

        return if (allNumbersMultiplication >= positiveNumberMultiplication) {
            allNumbersMultiplication;
        } else {
            positiveNumberMultiplication;
        };
    }
}
