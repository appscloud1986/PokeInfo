package com.appscloud.pokeinfo.api

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


interface ApiService {
    @GET("pokemon?limit=151")
    suspend fun getPokemonList(): String





}

 var retrofit = Retrofit.Builder()
    .baseUrl("https://pokeapi.co/api/v2/")
    .addConverterFactory(ScalarsConverterFactory.create())
    .build()

var service: ApiService = retrofit.create(ApiService::class.java)








/*
 @GET("pokemon/{id}")
    fun getPokemonInfo(@Path("id") id: Int): Call<Pokemon>
    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<ApiService>
 */