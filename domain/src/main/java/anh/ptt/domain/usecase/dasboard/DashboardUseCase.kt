package anh.ptt.domain.usecase.dasboard

import anh.ptt.core.Result
import anh.ptt.domain.entities.BuyEntity
import anh.ptt.domain.entities.CallEntity
import anh.ptt.domain.entities.SellEntity
import anh.ptt.domain.repository.DashboardRepository
import javax.inject.Inject

class DashboardUseCase @Inject constructor(
    private val dashboardRepository: DashboardRepository
) {

    suspend fun callListExecute(): Result<List<CallEntity>> =
        dashboardRepository.getCallList()

    suspend fun buyListExecute(): Result<List<BuyEntity>> =
        dashboardRepository.getBuyList()

    suspend fun sellListExecute(): Result<List<SellEntity>> =
        dashboardRepository.getSellList()

}