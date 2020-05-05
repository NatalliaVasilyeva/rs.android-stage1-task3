package subtask5

class TelephoneFinder {


    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.toInt() < 0) {
            return null;
        }
        val result = ArrayList<String>();

        val mapNumbers = mapOf(
            '0' to arrayOf(8),
            '1' to arrayOf(2, 4),
            '2' to arrayOf(1, 3, 5),
            '3' to arrayOf(2, 6),
            '4' to arrayOf(1, 5, 7),
            '5' to arrayOf(2, 4, 6, 8),
            '6' to arrayOf(3, 5, 9),
            '7' to arrayOf(4, 8),
            '8' to arrayOf(0, 5, 7, 9),
            '9' to arrayOf(6, 8)
        )

        for (i in number.indices) {
            val wrongNumber = number[i];
            val arrayOfNeigNumbers = mapNumbers[wrongNumber];

            if (!mapNumbers.containsKey(wrongNumber)) {
                return null;
            }

            for (neigIndex in arrayOfNeigNumbers!!.indices) {
                result.add(number.replaceRange(i, i + 1, arrayOfNeigNumbers[neigIndex].toString()));
            }
        }

        return result.toTypedArray()
    }
}
