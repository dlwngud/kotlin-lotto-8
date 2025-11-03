package lotto

class OutputHandler {

    fun printPurchaseAmountPrompt() {
        println(PROMPT_PURCHASE_AMOUNT)
    }

    fun printPurchaseCount(count: Int) {
        println()
        println(MESSAGE_PURCHASE_COUNT.format(count))
    }

    fun printLottoNumbers(lottoNumbers: List<Int>) {
        println(lottoNumbers)
    }

    companion object {
        const val PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
        const val PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
        const val PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."

        const val MESSAGE_PURCHASE_COUNT = "%d개를 구매했습니다."

        const val HEADER_STATISTICS = "당첨 통계"
        const val HEADER_SEPARATOR = "---"

        const val FORMAT_MATCH_3 = "3개 일치 (5,000원) - %d개"
        const val FORMAT_MATCH_4 = "4개 일치 (50,000원) - %d개"
        const val FORMAT_MATCH_5 = "5개 일치 (1,500,000원) - %d개"
        const val FORMAT_MATCH_5_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
        const val FORMAT_MATCH_6 = "6개 일치 (2,000,000,000원) - %d개"

        const val MESSAGE_YIELD = "총 수익률은 %.1f%%입니다."
    }
}