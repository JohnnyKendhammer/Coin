package com.example.timer.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coins_table")
data class CoinsItem(
    @ColumnInfo(name = "coin_id")
    val id: String,

    @ColumnInfo(name = "is_active")
    val is_active: Boolean,

    @ColumnInfo(name = "is_new")
    val is_new: Boolean,

    @ColumnInfo(name = "coin_name")
    val name: String,

    @ColumnInfo(name = "coin_rank")
    val rank: Int,

    @ColumnInfo(name = "coin_symbol")
    val symbol: String,

    @ColumnInfo(name = "coin_type")
    val type: String
){
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0

}

