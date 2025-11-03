package lotto

import camp.nextstep.edu.missionutils.Console

class InputHandler {
    val inputValidator = InputValidator()

    fun readPurchaseAmount(): Int {
        val purchaseAmount = Console.readLine().toIntOrNull()
            ?: throw IllegalArgumentException(ErrorMessage.INVALID_INPUT.message)
        inputValidator.validatePurchaseAmount(purchaseAmount)
        return purchaseAmount / InputValidator.PRICE_PER_LOTTO
    }
}