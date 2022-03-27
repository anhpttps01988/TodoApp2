package anh.ptt.data.di

import anh.ptt.data.datasource.remote.api.DashboardEndpoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSource {

    @Provides
    @Singleton
    fun provideDashboardService(retrofit: Retrofit): DashboardEndpoints =
        retrofit.create(DashboardEndpoints::class.java)

}