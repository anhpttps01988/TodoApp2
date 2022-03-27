package anh.ptt.todoapp.di

import anh.ptt.presentation.interact.DashboardNavigator
import anh.ptt.todoapp.navigator.DashboardNavigatorImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class NavigationModule {

    @Binds
    abstract fun bindDashboardNavigator(dashboardNavigatorImp: DashboardNavigatorImp): DashboardNavigator

}