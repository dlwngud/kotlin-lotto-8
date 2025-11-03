package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RankTest {

    @ParameterizedTest
    @CsvSource(
        "6, false, FIRST",
        "5, true, SECOND",
        "5, false, THIRD",
        "4, false, FOURTH",
        "3, false, FIFTH",
        "2, false, MISS",
        "0, true, MISS"
    )
    fun `valueOf는 매칭 수와 보너스 여부에 따라 올바른 등수 반환`(
        matchCount: Int, bonusMatch: Boolean, expected: Rank
    ) {
        val rank = Rank.valueOf(matchCount, bonusMatch)
        assertThat(rank).isEqualTo(expected)
    }

    @Test
    fun `getDisplayText는 MISS면 빈 문자열, 나머지는 형식화된 문자열 반환`() {
        assertThat(Rank.MISS.getDisplayText()).isEmpty()
        assertThat(Rank.FIFTH.getDisplayText()).isEqualTo("3개 일치 (5,000원)")
        assertThat(Rank.SECOND.getDisplayText()).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원)")
        assertThat(Rank.FIRST.getDisplayText()).isEqualTo("6개 일치 (2,000,000,000원)")
    }
}