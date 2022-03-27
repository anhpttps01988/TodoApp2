package anh.ptt.data.repository.features.dashboard

import android.app.Application
import anh.ptt.core.Result
import anh.ptt.core.ResultType
import anh.ptt.data.R
import anh.ptt.data.datasource.local.dao.SellDao
import anh.ptt.data.datasource.remote.api.DashboardEndpoints
import anh.ptt.data.device.network.NetworkChecker
import anh.ptt.data.repository.mapper.BuyListMapper
import anh.ptt.data.repository.mapper.CallListMapper
import anh.ptt.data.repository.mapper.SellListMapper
import anh.ptt.domain.entities.BuyEntity
import anh.ptt.domain.entities.CallEntity
import anh.ptt.domain.entities.SellEntity
import anh.ptt.domain.repository.DashboardRepository
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.lastOrNull
import javax.inject.Inject

class DashboardRepositoryImp @Inject constructor(
    private val dashboardEndpoints: DashboardEndpoints,
    private val networkChecker: NetworkChecker,
    private val application: Application,
    private val sellDao: SellDao
): DashboardRepository {

    override suspend fun getSellList(): Result<List<SellEntity>> {
        return try {
            val result = SellListMapper().map(sellDao.getAll())
            Result(resultType = ResultType.SUCCESS, data = result)
        } catch (e: Exception) {
            Result(resultType = ResultType.ERROR, error = e)
        }
    }

    override suspend fun getCallList(): Result<List<CallEntity>> {
        return try {
            if (networkChecker.isOnline()) {
                val response = dashboardEndpoints.getCallList()
                if (response.isSuccessful) {
                    val res = response.body()
                    val callEntities: List<CallEntity> = CallListMapper().map(res)
                    if (res != null) {
                        Result(resultType = ResultType.SUCCESS, data = callEntities)
                    } else {
                        Result(resultType = ResultType.ERROR, error = Exception(response.message()))
                    }
                } else {
                    Result(resultType = ResultType.SUCCESS, data = null)
                }
            } else {
                Result(resultType = ResultType.ERROR, error = Exception(application.getString(R.string.no_internet)))
            }
        } catch (e: Exception) {
            Result(resultType = ResultType.ERROR, error = e)
        }
    }

    override suspend fun getBuyList(): Result<List<BuyEntity>> {
        return try {
            if (networkChecker.isOnline()) {
                val response = dashboardEndpoints.getBuyList()
                if (response.isSuccessful) {
                    val res = response.body()
                    val buyEntities: List<BuyEntity> = BuyListMapper().map(res)
                    if (res != null) {
                        Result(resultType = ResultType.SUCCESS, data = buyEntities)
                    } else {
                        Result(resultType = ResultType.ERROR, error = Exception(response.message()))
                    }
                } else {
                    Result(resultType = ResultType.SUCCESS, data = null)
                }
            } else {
                Result(resultType = ResultType.ERROR, error = Exception(application.getString(R.string.no_internet)))
            }
        } catch (e: Exception) {
            Result(resultType = ResultType.ERROR, error = e)
        }
    }
}