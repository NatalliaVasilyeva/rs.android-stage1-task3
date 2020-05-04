package subtask4

import kotlin.math.floor
import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        return decomposeRecursia(number * number, number - 1);

    }

    private fun decomposeRecursia(rest: Int, number: Int): Array<Int>? {

        for (i in number downTo 1) {
            var square = i * i;
            var nRest = rest - square;
            if (nRest == 0) {
                return arrayOf(i);
            }
            if (nRest < 0) {
                return null;
            }

            var squareRoot = floor(sqrt(nRest.toDouble())).toInt();

            if (squareRoot >= i) {
                squareRoot = i - 1
            }

            var result = decomposeRecursia(nRest, squareRoot);

            if (result != null) return result + arrayOf(i)

        }
        return null;

    }
}
