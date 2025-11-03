package lotto

class LottoController {
    val inputHandler = InputHandler()
    val outputHandler = OutputHandler()

    fun startLottoGame() {
        outputHandler.printPurchaseAmountPrompt()
        val purchaseAmountInput = inputHandler.readPurchaseAmount()
        outputHandler.printPurchaseCount(purchaseAmountInput)
        val lottos = LottoGenerator.generateLotto(purchaseAmountInput)
        lottos.map { lotto ->
            val sortedNumbers = lotto.sortedNumbers()
            outputHandler.printLottoNumbers(sortedNumbers)
        }
        outputHandler.printWinningNumbersPrompt()
        val winningNumbersInput = inputHandler.readWinningNumbers()
        outputHandler.printBonusNumberPrompt()
        val bonusNumberInput = inputHandler.readBonusNumber(winningNumbersInput)
        val lottoResult = LottoResult(lottos, winningNumbersInput, bonusNumberInput)
        outputHandler.printStatistics(lottoResult.states)
        val yield = lottoResult.calculateYield(purchaseAmountInput)
        outputHandler.printYield(yield)
    }
}