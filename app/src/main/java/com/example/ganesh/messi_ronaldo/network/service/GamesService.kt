package com.example.ganesh.messi_ronaldo.network.service

import com.example.ganesh.messi_ronaldo.domain.model.Games
import com.example.ganesh.messi_ronaldo.domain.model.GamesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GamesService {

    @GET("games")
    suspend fun getAllGames(
        @Query("key") key: String,
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int,
    ): GamesResponse

    @GET("games/{id}")
    suspend fun getGamesDetail(
        @Path("id") id: Int,
        @Query("key") key: String,
    ): Games
}