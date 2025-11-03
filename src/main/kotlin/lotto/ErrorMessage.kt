package lotto

enum class ErrorMessage(val message: String) {
    INVALID_INPUT("[ERROR] 숫자를 입력해주세요."),
    NEGATIVE_AMOUNT("[ERROR] 구입 금액은 0보다 커야 합니다."),
    INVALID_AMOUNT("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    SIX_NUMBER("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    BONUS_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안 됩니다.");
}