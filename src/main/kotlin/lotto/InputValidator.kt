package lotto

class InputValidator {
    fun validatePurchaseAmount(amount: Int?) {
        if (amount == null) throw IllegalArgumentException(ErrorMessage.INVALID_INPUT.message)
        if (amount <= 0) throw IllegalArgumentException(ErrorMessage.NEGATIVE_AMOUNT.message)
        if (amount % PRICE_PER_LOTTO != 0) throw IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.message)
    }

    fun validateWinningNumbers(winningNumbers: List<Int>) {
        if (winningNumbers.size != 6) throw IllegalArgumentException(ErrorMessage.SIX_NUMBER.message)
        if (winningNumbers.any { it !in 1..45 }) throw IllegalArgumentException(ErrorMessage.INVALID_NUMBER.message)
        if (winningNumbers.size != winningNumbers.toSet().size) throw IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.message)
    }

    fun validateBonusNumber(bonusNumber: Int?, winningNumbers: List<Int>) {
        if (bonusNumber == null) throw IllegalArgumentException(ErrorMessage.INVALID_INPUT.message)
        if (bonusNumber !in 1..45) throw IllegalArgumentException(ErrorMessage.INVALID_NUMBER.message)
        if (winningNumbers.contains(bonusNumber)) throw IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE.message)
    }

    companion object {
        const val PRICE_PER_LOTTO = 1_000
    }
}