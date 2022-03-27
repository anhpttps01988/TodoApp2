package anh.ptt.data.datasource.remote.rest

import android.app.Application
import anh.ptt.data.R
import anh.ptt.data.device.network.NetworkChecker
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class NetworkInterceptor @Inject constructor(
    private val networkCheckerData: NetworkChecker,
    private val context: Application
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (networkCheckerData.isOnline()) {
            val builder = chain.request().newBuilder()
            try {
                val res = chain.proceed(builder.build())
                return when (res.code) {
                    400, 403, 422, 502, 500 -> convertByPassResponseErr(res)
                    401 ->  convertByPassResponseErr(res)
                    200, 204 -> res
                    else -> throw(IOException(context.getString(R.string.server_error)))
                }
            } catch (e: IOException) {
                throw(e)
            }
        } else {
            throw(IOException(context.getString(R.string.no_internet)))
        }
    }

    private fun convertByPassResponseErr(res: Response): Response {
        return Response.Builder()
            .body(res.body)
            .code(200)
            .message(res.message)
            .networkResponse(res.networkResponse)
            .cacheResponse(res.cacheResponse)
            .protocol(res.protocol)
            .handshake(res.handshake)
            .priorResponse(res.priorResponse)
            .request(res.request)
            .build()
    }

}