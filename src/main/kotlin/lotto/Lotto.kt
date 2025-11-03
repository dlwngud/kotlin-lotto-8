package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ErrorMessage.SIX_NUMBER.message }
        require(numbers.all { it in 1..45 }) { ErrorMessage.INVALID_NUMBER.message }
        require(numbers.size == numbers.toSet().size) { ErrorMessage.DUPLICATE_NUMBER.message }
    }

    fun sortedNumbers() = numbers.sorted()
}