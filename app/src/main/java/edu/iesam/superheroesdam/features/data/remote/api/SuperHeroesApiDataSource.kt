package edu.iesam.superheroesdam.features.data.remote.api

import edu.iesam.superheroesdam.core.ErrorApp
import edu.iesam.superheroesdam.core.api.ApiClient
import edu.iesam.superheroesdam.features.domain.SuperHeroe
import android.util.Log
class SuperHeroesApiDataSource(private val apiClient: ApiClient) {


    fun getSuperHeroes(): Result<List<SuperHeroe>> {
        //ENTRAN APIMODELS (SuperHeroeApiModel)
        //SALEN MODELS (SuperHeroe)
        val apiService = apiClient.createService(SuperHeroeApiService::class.java)
        val resultSuperHeroe = apiService.findAll().execute()
        //JAVA VERSION:
        if(resultSuperHeroe.isSuccessful && resultSuperHeroe.errorBody() == null){
            val listSuperHeroeApiModel : List<SuperHeroeApiModel> = resultSuperHeroe.body()!!
            val listSuperHeroe = listSuperHeroeApiModel.map { superHeroeApiModel ->
                superHeroeApiModel.toModel()
            }
            return Result.success(listSuperHeroe)
        } else {
            return Result.failure(ErrorApp.ServerError)
        }
        //KOTLIN VERSION:
        /*
            //return Result.success(resultSuperHero.body()!!.map {
            it.toModel()
            }
         */
        Log.d("@dev", "Hola2")
        return Result.success(listOf())

    }
}