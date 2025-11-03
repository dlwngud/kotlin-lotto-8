package lotto

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {

    private val validator = InputValidator()

    @Test
    fun `구매 금액이 null이면 예외 발생`() {
        assertThatThrownBy { validator.validatePurchaseAmount(null) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessage.INVALID_INPUT.message)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1000, 0])
    fun `구매 금액이 0 이하이면 예외 발생`(amount: Int) {
        assertThatThrownBy { validator.validatePurchaseAmount(amount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessage.NEGATIVE_AMOUNT.message)
    }

    @ParameterizedTest
    @ValueSource(ints = [500, 1500, 2500])
    fun `구매 금액이 1000원 단위가 아니면 예외 발생`(amount: Int) {
        assertThatThrownBy { validator.validatePurchaseAmount(amount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessage.INVALID_AMOUNT.message)
    }

    @Test
    fun `정상적인 구매 금액은 통과`() {
        validator.validatePurchaseAmount(1000)
        validator.validatePurchaseAmount(5000)
        // No exception
    }

    @Test
    fun `당첨 번호가 6개가 아니면 예외 발생`() {
        assertThatThrownBy { validator.validateWinningNumbers(listOf(1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessage.SIX_NUMBER.message)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `당첨 번호에 1~45 범위를 벗어나는 숫자가 있으면 예외 발생`(number: Int) {
        val numbers = listOf(1, 2, 3, 4, 5, number)
        assertThatThrownBy { validator.validateWinningNumbers(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessage.INVALID_NUMBER.message)
    }

    @Test
    fun `당첨 번호에 중복이 있으면 예외 발생`() {
        assertThatThrownBy { validator.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessage.DUPLICATE_NUMBER.message)
    }

    @Test
    fun `보너스 번호가 null이면 예외 발생`() {
        assertThatThrownBy { validator.validateBonusNumber(null, listOf(1, 2, 3, 4, 5, 6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessage.INVALID_INPUT.message)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `보너스 번호가 1~45 범위를 벗어나면 예외 발생`(bonus: Int) {
        assertThatThrownBy { validator.validateBonusNumber(bonus, listOf(1, 2, 3, 4, 5, 6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessage.INVALID_NUMBER.message)
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외 발생`() {
        assertThatThrownBy { validator.validateBonusNumber(3, listOf(1, 2, 3, 4, 5, 6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessage.BONUS_DUPLICATE.message)
    }
}