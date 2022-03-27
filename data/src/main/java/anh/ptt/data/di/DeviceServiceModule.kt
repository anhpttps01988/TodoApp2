package anh.ptt.data.di

import anh.ptt.data.device.network.NetworkChecker
import anh.ptt.data.device.network.NetworkCheckerImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DeviceServiceModule {

    @Binds
    abstract fun bindNetworkChecker(networkCheckerImp: NetworkCheckerImp): NetworkChecker

}