package edu.iesam.superheroesdam.features.data.remote.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroeApiService {

    @GET("all.json")
    suspend fun findAll(): Response<List<SuperHeroeApiModel>>

    @GET("id/{superHeroeId}.json")
    suspend fun findById(@Path("superHeroeId") id: String)
}