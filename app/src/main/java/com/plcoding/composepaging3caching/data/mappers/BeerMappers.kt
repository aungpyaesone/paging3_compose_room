package com.plcoding.composepaging3caching.data.mappers

import com.plcoding.composepaging3caching.data.remote.BeerDto
import com.plcoding.composepaging3caching.domain.Beer
import com.plcoding.composepaging3caching.local.BeerEntity

fun BeerDto.toBeerEntity(): BeerEntity {
    return BeerEntity(
        id = id, name = name, description = description, tagline = tagline,
        imageUrl = image_url, firstBrewed = first_brewed
    )
}

fun BeerEntity.toBeer(): Beer {
    return Beer(id, name, description, tagline, firstBrewed, imageUrl)
}