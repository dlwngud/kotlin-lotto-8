package lotto

import camp.nextstep.edu.missionutils.Console

class InputHandler {
    val inputValidator = InputValidator()

    fun readPurchaseAmount(): Int {
        println(OutputHandler.PROMPT_PURCHASE_AMOUNT)
        val purchaseAmount = Console.readLine().toIntOrNull()
            ?: throw IllegalArgumentException(ErrorMessage.INVALID_INPUT.message)
        inputValidator.validatePurchaseAmount(purchaseAmount)
        return purchaseAmount
    }
}