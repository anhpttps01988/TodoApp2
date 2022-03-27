package anh.ptt.domain.repository

import anh.ptt.core.Result
import anh.ptt.domain.entities.BuyEntity
import anh.ptt.domain.entities.CallEntity
import anh.ptt.domain.entities.SellEntity

interface DashboardRepository {

    suspend fun getCallList(): Result<List<CallEntity>>

    suspend fun getBuyList(): Result<List<BuyEntity>>

    suspend fun getSellList(): Result<List<SellEntity>>
}