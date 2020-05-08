package com.akshay.dragonballfamily.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by akshaynandwana on
 * 08, May, 2020
 **/

@Entity(tableName = "dragonBallTable")
data class DragonBallEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "name")
    var name: String
)