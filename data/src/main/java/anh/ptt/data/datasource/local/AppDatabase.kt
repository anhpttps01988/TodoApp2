package anh.ptt.data.datasource.local

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import anh.ptt.data.datasource.local.dao.SellDao
import anh.ptt.data.datasource.local.model.SellLocalModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [SellLocalModel::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun sellDao(): SellDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "itemtosell_database"
                ).addCallback(CALLBACK).build()
                INSTANCE = instance
                return instance
            }
        }

        private val CALLBACK = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let {
                    CoroutineScope(Dispatchers.IO).launch {
                        val sellDao = it.sellDao()

                        var sell = SellLocalModel(
                            id = 1,
                            name = "Table",
                            price = 12000,
                            quantity = 1,
                            type = 2
                        )
                        sellDao.insert(sell)
                        sell = SellLocalModel(
                            id = 2,
                            name = "TV",
                            price = 38000,
                            quantity = 2,
                            type = 2
                        )
                        sellDao.insert(sell)
                        sell = SellLocalModel(
                            id = 3,
                            name = "iPhone X",
                            price = 150000,
                            quantity = 1,
                            type = 2
                        )
                        sellDao.insert(sell)
                    }
                }
            }
        }
    }



}