package lotto

enum class Rank(
    val matchCount: Int,
    val bonusRequired: Boolean,
    val prize: Long,
    private val description: String
) {
    MISS(0, false, 0L, "꽝"),
    FIFTH(3, false, 5_000L, "3개 일치"),
    FOURTH(4, false, 50_000L, "4개 일치"),
    THIRD(5, false, 1_500_000L, "5개 일치"),
    SECOND(5, true, 30_000_000L, "5개 일치, 보너스 볼 일치"),
    FIRST(6, false, 2_000_000_000L, "6개 일치");

    fun getDisplayText(): String {
        return if (this == MISS) {
            ""
        } else {
            "$description (%,d원)".format(prize)
        }
    }

    companion object {
        fun valueOf(matchCount: Int, bonusMatch: Boolean): Rank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && bonusMatch -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> MISS
            }
        }
    }
}