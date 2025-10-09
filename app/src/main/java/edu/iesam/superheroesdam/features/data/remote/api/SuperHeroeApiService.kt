package edu.iesam.superheroesdam.features.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroeApiService {

    @GET("all.json")
    fun findAll(): List<SuperHeroeApiModel>

    @GET("id/{superHeroeId}.json")
    fun findById(@Path("superHeroeId") id: String)
}