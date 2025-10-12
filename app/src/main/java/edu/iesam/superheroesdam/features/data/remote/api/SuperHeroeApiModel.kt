package edu.iesam.superheroesdam.features.data.remote.api

data class SuperHeroeApiModel
    (val id: String,
     val name: String,
     val slug: String,
     val images: SuperHeroeImageApiModel) {
}

data class SuperHeroeImageApiModel
    (val xs: String,
     val sm: String,
     val md: String,
     val lg: String){

}