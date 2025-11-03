package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoGenerator {
    fun generateLotto(count: Int): List<Lotto> {
        return List(count) { Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)) }
    }
}