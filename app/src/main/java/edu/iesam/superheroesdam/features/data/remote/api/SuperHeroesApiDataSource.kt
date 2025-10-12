package edu.iesam.superheroesdam.features.data.remote.api

import edu.iesam.superheroesdam.core.ErrorApp
import edu.iesam.superheroesdam.core.api.ApiClient
import edu.iesam.superheroesdam.features.domain.SuperHeroe
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class SuperHeroesApiDataSource(private val apiClient: ApiClient) {


    suspend fun getSuperHeroes(): Result<List<SuperHeroe>> {
        //ENTRAN APIMODELS (SuperHeroeApiModel)
        //SALEN MODELS (SuperHeroe)
        return withContext(Dispatchers.IO) {
            val apiService = apiClient.createService(SuperHeroeApiService::class.java)
            val resultSuperHeroe = apiService.findAll().execute()
            //JAVA VERSION:
            if (resultSuperHeroe.isSuccessful && resultSuperHeroe.errorBody() == null) {
                val listSuperHeroeApiModel: List<SuperHeroeApiModel> = resultSuperHeroe.body()!!
                val listSuperHeroe = listSuperHeroeApiModel.map { superHeroeApiModel ->
                    superHeroeApiModel.toModel()
                }
                 Result.success(listSuperHeroe)
            } else {
                 Result.failure(ErrorApp.ServerError)
            }

        }

        //KOTLIN VERSION:
        /*
            //return Result.success(resultSuperHero.body()!!.map {
            it.toModel()
            }
         */



    }
}