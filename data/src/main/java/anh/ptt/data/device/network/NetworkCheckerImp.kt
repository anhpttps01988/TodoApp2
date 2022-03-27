package anh.ptt.data.device.network

import anh.ptt.device.network.NetworkHelper
import javax.inject.Inject

class NetworkCheckerImp @Inject constructor(
    private val networkHelper: NetworkHelper
) : NetworkChecker {
    override fun isOnline(): Boolean {
        return networkHelper.isNetworkConnected()
    }
}