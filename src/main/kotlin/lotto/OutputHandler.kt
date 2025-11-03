package lotto

class OutputHandler {

    fun printPurchaseAmountPrompt() {
        println(PROMPT_PURCHASE_AMOUNT)
    }

    fun printWinningNumbersPrompt() {
        println()
        println(PROMPT_WINNING_NUMBERS)
    }

    fun printBonusNumberPrompt() {
        println()
        println(PROMPT_BONUS_NUMBER)
    }

    fun printPurchaseCount(count: Int) {
        println()
        println(MESSAGE_PURCHASE_COUNT.format(count))
    }

    fun printLottoNumbers(lottoNumbers: List<Int>) {
        println(lottoNumbers)
    }

    fun printStatistics(statistics: Map<Rank, Int>) {
        println()
        println(HEADER_STATISTICS)
        println(HEADER_SEPARATOR)
        Rank.entries.filter { it != Rank.MISS }.forEach { rank ->
            val count = statistics[rank]
            println("${rank.getDisplayText()} - ${count}개")
        }
    }

    fun printYield(yield: Double) {
        println(MESSAGE_YIELD.format(yield))
    }

    companion object {
        const val PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
        const val PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
        const val PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."

        const val MESSAGE_PURCHASE_COUNT = "%d개를 구매했습니다."

        const val HEADER_STATISTICS = "당첨 통계"
        const val HEADER_SEPARATOR = "---"

        const val MESSAGE_YIELD = "총 수익률은 %.1f%%입니다."
    }
}