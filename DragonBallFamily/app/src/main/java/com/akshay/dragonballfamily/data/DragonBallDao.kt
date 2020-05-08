package com.akshay.dragonballfamily.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Created by akshaynandwana on
 * 08, May, 2020
 **/

@Dao
interface DragonBallDao {

    @Insert
    suspend fun insert(dragonBall: DragonBallEntity)

    @Query("SELECT * FROM dragonBallTable")
    fun getCompleteDragonBallTeam(): List<DragonBallEntity>

    @Query("DELETE FROM dragonBallTable")
    suspend fun deleteCompleteTable()

}