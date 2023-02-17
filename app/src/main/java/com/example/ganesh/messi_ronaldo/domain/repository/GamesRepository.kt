package com.example.ganesh.messi_ronaldo.domain.repository

import androidx.paging.PagingData
import com.example.ganesh.messi_ronaldo.domain.model.Games
import com.example.ganesh.messi_ronaldo.utils.Response
import kotlinx.coroutines.flow.Flow

interface GamesRepository {
    fun getAllGames(): Flow<PagingData<Games>>
    fun getDetailGames(id: Int): Flow<Response<Games>>
}