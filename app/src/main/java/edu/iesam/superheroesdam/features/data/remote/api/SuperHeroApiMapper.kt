package edu.iesam.superheroesdam.features.data.remote.api

import edu.iesam.superheroesdam.features.domain.SuperHeroe

fun SuperHeroeApiModel.toModel() : SuperHeroe {
    return SuperHeroe(
        this.id,
        this.name,
        this.slug,
        this.images.md
    )
}