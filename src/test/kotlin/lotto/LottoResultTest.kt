package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.Percentage
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `LottoResult는 모든 로또에 대해 등수를 계산하고 통계를 저장한다`() {
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),   // 6개 → 1등
            Lotto(listOf(1, 2, 3, 4, 5, 7)),   // 5개, 보너스 아님 → 3등
            Lotto(listOf(1, 2, 3, 4, 5, 8)),   // 5개, 보너스 있음 → 2등
            Lotto(listOf(1, 2, 3, 10, 11, 12)), // 3개 → 5등
            Lotto(listOf(10, 11, 12, 13, 14, 15)) // 0개 → MISS
        )
        val winning = listOf(1, 2, 3, 4, 5, 6)
        val bonus = 8

        val result = LottoResult(lottos, winning, bonus)

        val stats = result.states
        assertThat(stats[Rank.FIRST]).isEqualTo(1)
        assertThat(stats[Rank.SECOND]).isEqualTo(1)
        assertThat(stats[Rank.THIRD]).isEqualTo(1)
        assertThat(stats[Rank.FOURTH]).isEqualTo(0)
        assertThat(stats[Rank.FIFTH]).isEqualTo(1)
        assertThat(stats[Rank.MISS]).isEqualTo(1)
    }

    @Test
    fun `calculateYield는 총 상금 대비 수익률을 정확히 계산한다`() {
        val lottos = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6))) // 1등
        val winning = listOf(1, 2, 3, 4, 5, 6)
        val bonus = 7
        val purchaseAmount = 1000

        val result = LottoResult(lottos, winning, bonus)
        val yield = result.calculateYield(purchaseAmount)

        // 2,000,000,000 / 1000 = 2,000,000 → *100 / 1000 = 200,000.0%
        assertThat(yield).isCloseTo(200000.0, Percentage.withPercentage(0.1))
    }

    @Test
    fun `calculateYield는 MISS는 상금 계산에서 제외된다`() {
        val lottos = listOf(Lotto(listOf(10, 11, 12, 13, 14, 15)))
        val result = LottoResult(lottos, listOf(1, 2, 3, 4, 5, 6), 7)
        val yield = result.calculateYield(1000)
        assertThat(yield).isEqualTo(0.0)
    }

    @Test
    fun `calculateYield는 여러 등수일 때 총 상금을 합산한다`() {
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),   // 1등
            Lotto(listOf(1, 2, 3, 4, 5, 7))    // 5개, 보너스 아님 → 3등
        )
        val result = LottoResult(lottos, listOf(1, 2, 3, 4, 5, 6), 8)
        val yield = result.calculateYield(2000)

        val totalPrize = 2_000_000_000L + 1_500_000L
        val expected = (totalPrize.toDouble() / 2000) * 100 / 1000
        assertThat(yield).isCloseTo(expected, Percentage.withPercentage(0.1))
    }
}