package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    @Test
    fun `generateLotto는 요청한 개수만큼 Lotto 객체를 생성한다`() {
        val count = 3
        val lottos = LottoGenerator.generateLotto(count)
        assertThat(lottos).hasSize(count)
    }

    @Test
    fun `generateLotto는 각 Lotto가 유효한 6개의 서로 다른 번호를 가진다`() {
        val lottos = LottoGenerator.generateLotto(10)
        lottos.forEach { lotto ->
            val numbers = lotto.sortedNumbers()
            assertThat(numbers).hasSize(6)
            assertThat(numbers).doesNotHaveDuplicates()
            assertThat(numbers).allMatch { it in 1..45 }
        }
    }
}