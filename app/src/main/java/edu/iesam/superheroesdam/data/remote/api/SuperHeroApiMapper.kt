package edu.iesam.superheroesdam.data.remote.api

import edu.iesam.superheroesdam.domain.SuperHeroe

fun SuperHeroeApiModel.toModel() : SuperHeroe {
    return SuperHeroe(
        this.id,
        this.name,
        this.slug,
        this.images.md
    )
}