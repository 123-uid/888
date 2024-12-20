package com.example.a1base.ulits

import com.example.a1base.ekity.FileElity
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface Api {

    @GET("67499a94769a4a4330697645/api/resource/all")
    fun getfile():Flow<FileElity>

}