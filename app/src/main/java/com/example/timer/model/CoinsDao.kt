package com.example.timer.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CoinsDao {

    @Query("SELECT * FROM coins_table")
    suspend fun getCoins(): List<CoinsItem>

    @Query("DELETE FROM coins_table")
    suspend fun deleteAllCoins()

    @Insert
    suspend fun insertAll(list: ArrayList<CoinsItem>): List<Long>

    @Query("SELECT * FROM coins_table WHERE uuid = :coinId")
    suspend fun getCoin(coinId: Int): CoinsItem
}