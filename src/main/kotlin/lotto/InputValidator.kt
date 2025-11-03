package lotto

class InputValidator {
    fun validatePurchaseAmount(amount: Int?) {
        if (amount == null) throw IllegalArgumentException(ErrorMessage.INVALID_INPUT.message)
        if (amount <= 0) throw IllegalArgumentException(ErrorMessage.NEGATIVE_AMOUNT.message)
        if (amount % PRICE_PER_LOTTO != 0) throw IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.message)
    }

    companion object {
        const val PRICE_PER_LOTTO = 1_000
    }
}