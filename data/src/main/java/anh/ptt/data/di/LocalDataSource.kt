package anh.ptt.data.di

import android.content.Context
import anh.ptt.data.datasource.local.AppDatabase
import anh.ptt.data.datasource.local.dao.SellDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSource {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return AppDatabase.getDatabase(appContext)
    }

    @Provides
    @Singleton
    fun provideSellDao(appDatabase: AppDatabase): SellDao {
        return appDatabase.sellDao()
    }

}