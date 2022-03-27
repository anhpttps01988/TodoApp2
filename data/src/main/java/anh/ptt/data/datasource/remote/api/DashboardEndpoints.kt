package anh.ptt.data.datasource.remote.api

import anh.ptt.data.datasource.remote.model.response.BuyResponse
import anh.ptt.data.datasource.remote.model.response.CallResponse
import anh.ptt.data.datasource.remote.rest.RestConfig
import retrofit2.Response
import retrofit2.http.GET

interface DashboardEndpoints {

    @GET(RestConfig.API_CALL_LIST)
    suspend fun getCallList(): Response<List<CallResponse>>

    @GET(RestConfig.API_BUY_LIST)
    suspend fun getBuyList(): Response<List<BuyResponse>>

}