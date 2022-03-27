package anh.ptt.todoapp.di

import android.app.Application
import android.content.Context
import anh.ptt.data.datasource.remote.rest.BuildConfig
import anh.ptt.todoapp.config.BuildConfigImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BuildConfigModule {

    @Binds
    abstract fun bindAppContext(application: Application): Context

    @Binds
    abstract fun bindBuildConfig(
        buildConfigImp: BuildConfigImp
    ): BuildConfig

}