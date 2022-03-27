package anh.ptt.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import anh.ptt.data.datasource.local.model.SellLocalModel

@Dao
interface SellDao {

    @Query("SELECT * FROM ItemToSell")
    suspend fun getAll(): List<SellLocalModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(sellLocalModel: SellLocalModel)

}