package com.example.a1base.base

import com.example.a1base.ekity.FileElity
import com.example.a1base.ulits.Api
import com.example.a1base.ulits.RetrofitUlits
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@OptIn
class BaseRest @Inject constructor() {

    val api by lazy {
        RetrofitUlits.retrofit().create(Api::class.java)
    }

    fun getflie():Flow<FileElity>{
        return api.getfile()
    }

}