package anh.ptt.data.di

import anh.ptt.data.repository.features.dashboard.DashboardRepositoryImp
import anh.ptt.domain.repository.DashboardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindDashboardRepository(
        dashboardRepositoryImp: DashboardRepositoryImp
    ): DashboardRepository

}