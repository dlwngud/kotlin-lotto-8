package lotto

import camp.nextstep.edu.missionutils.Console

class InputHandler {
    val inputValidator = InputValidator()

    fun readPurchaseAmount(): Int {
        val purchaseAmount = Console.readLine().toIntOrNull()
        inputValidator.validatePurchaseAmount(purchaseAmount)
        return purchaseAmount!! / InputValidator.PRICE_PER_LOTTO
    }

    fun readWinningNumbers(): List<Int> {
        val input = Console.readLine()
        val winningNumbers = input.split(",").map { it.trim().toInt() }
        inputValidator.validateWinningNumbers(winningNumbers)
        return winningNumbers
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        val bonusNumber = Console.readLine().toIntOrNull()
        inputValidator.validateBonusNumber(bonusNumber, winningNumbers)
        return bonusNumber!!
    }
}