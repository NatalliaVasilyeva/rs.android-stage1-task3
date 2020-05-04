package subtask1

import java.lang.StringBuilder
import kotlin.math.abs

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (numbers.isNullOrEmpty()) return null;
        val result = StringBuilder();
        val arraySize = numbers.size;
        for (i in numbers.indices) {
            val currentNumber = numbers[i];
            val power = arraySize - i - 1;
            val absCurrentNumber = abs(currentNumber);
            if (i == numbers.lastIndex) {
                if (currentNumber > 0) {
                    result.append(" + ").append("$absCurrentNumber")
                } else {
                    result.append(" - ").append("$absCurrentNumber");
                }
            } else if (absCurrentNumber != 0) {
                if (power == arraySize - 1 && currentNumber > 0) {
                    result.append("")
                } else {
                    if (currentNumber > 0) {
                        result.append(" + ")
                    } else {
                        result.append(" - ");
                    }
                }
                if (absCurrentNumber != 1) {
                    if (power > 0 && power != 1) {
                        result.append("$absCurrentNumber").append("x").append("^$power");

                    } else if (power == 1) {
                        result.append("$absCurrentNumber").append("x")
                    }
                } else {
                    result.append("x")
                }
            }
        }

        return result.toString();

    }
}
