package lotto

class LottoResult(
    private val lottos: List<Lotto>,
    private val winning: List<Int>,
    private val bonus: Int
) {
    private val _stats = mutableMapOf<Rank, Int>().apply {
        Rank.entries.forEach { put(it, 0) }
    }
    val states: Map<Rank, Int> get() = _stats

    init {
        calculate()
    }

    private fun calculate() {
        lottos.forEach { lotto ->
            val matchCount = lotto.countMatch(winning)
            val bonusMatch = lotto.contains(bonus)
            val rank = Rank.valueOf(matchCount, bonusMatch)
            _stats[rank] = _stats[rank]!! + 1
        }
    }

    fun calculateYield(purchaseAmount: Int): Double {
        val totalPrize = _stats.entries
            .filter { it.key != Rank.MISS }
            .sumOf { (rank, count) -> rank.prize * count }
        return (totalPrize.toDouble() / purchaseAmount) * 100 / 1000
    }
}